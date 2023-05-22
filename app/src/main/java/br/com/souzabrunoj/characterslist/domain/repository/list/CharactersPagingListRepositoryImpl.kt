package br.com.souzabrunoj.characterslist.domain.repository.list

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import br.com.souzabrunoj.characterslist.data.list.response.CharactersListResultResponse
import br.com.souzabrunoj.characterslist.data.list.service.CharactersListService
import br.com.souzabrunoj.characterslist.domain.paging.CharacterPagingSource

private const val PAGING_SIZE = 30
private const val PRE_FETCH = 100

class CharactersPagingListRepositoryImpl(private val service: CharactersListService) : CharactersPagingListRepository {
    override fun getCharactersList(): LiveData<PagingData<CharactersListResultResponse>> {
        return Pager(
            config = PagingConfig(PAGING_SIZE, PRE_FETCH),
            pagingSourceFactory = {
                CharacterPagingSource(service)
            }
        ).liveData
    }
}