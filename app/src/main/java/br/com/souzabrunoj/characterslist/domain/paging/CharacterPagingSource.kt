package br.com.souzabrunoj.characterslist.domain.paging

import android.annotation.SuppressLint
import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.souzabrunoj.characterslist.data.list.service.CharactersListService
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult
import br.com.souzabrunoj.characterslist.domain.data.list.toDomain

private const val NUMBER_ONE = 1
@SuppressLint("all")
class CharacterPagingSource(
    private val service: CharactersListService
) : PagingSource<Int, CharactersListResult>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharactersListResult> {
        return try {
            val position = params.key ?: NUMBER_ONE
            val response = service.getCharacterList(position, "", "").toDomain()
            LoadResult.Page(
                data = response.results,
                prevKey = if (position == NUMBER_ONE) null else position.minus(NUMBER_ONE),
                nextKey = if (position == response.totalPages) null else position.plus(NUMBER_ONE)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharactersListResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(NUMBER_ONE) ?: anchorPage?.nextKey?.minus(NUMBER_ONE)
        }
    }
}