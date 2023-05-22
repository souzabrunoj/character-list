package br.com.souzabrunoj.characterslist.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.souzabrunoj.characterslist.data.list.response.CharactersListResultResponse
import br.com.souzabrunoj.characterslist.data.list.service.CharactersListService

private const val NUMBER_ONE = 1

class CharacterPagingSource(
    private val service: CharactersListService
) : PagingSource<Int, CharactersListResultResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharactersListResultResponse> {
        return try {
            val position = params.key ?: NUMBER_ONE
            val response = service.getCharacterList(position)
            LoadResult.Page(
                data = response.results,
                prevKey = if (position == NUMBER_ONE) null else position.minus(NUMBER_ONE),
                nextKey = if (position == response.info.pages) null else position.plus(NUMBER_ONE)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharactersListResultResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(NUMBER_ONE) ?: anchorPage?.nextKey?.minus(NUMBER_ONE)
        }
    }
}