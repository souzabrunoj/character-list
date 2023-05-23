package br.com.souzabrunoj.characterslist.domain.repository.list

import androidx.lifecycle.LiveData
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import br.com.souzabrunoj.characterslist.data.list.service.CharactersListService
import br.com.souzabrunoj.characterslist.dataLocal.dataBase.CharacterListDataBase
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult
import br.com.souzabrunoj.characterslist.domain.paging.CharacterListRemoteMediator

private const val PAGING_SIZE = 30
private const val PRE_FETCH = 100

@OptIn(ExperimentalPagingApi::class)
class CharactersPagingListRepositoryImpl(
    private val name: String,
    private val status: String,
    private val dataRemote: CharactersListService,
    private val dataLocal: CharacterListDataBase
) : CharactersPagingListRepository {
    override fun getCharactersList(): LiveData<PagingData<CharactersListResult>> {
        return Pager(
            config = PagingConfig(PAGING_SIZE, PRE_FETCH),
            remoteMediator = CharacterListRemoteMediator(name, status, dataRemote, dataLocal),
            pagingSourceFactory = {
                when {
                    name.isNotEmpty() -> dataLocal.charactersDao().getCharactersWithNameFilter(name)
                    status.isNotEmpty() -> dataLocal.charactersDao().getCharactersWithStatusFilter(status)
                    else -> dataLocal.charactersDao().getCharacters()
                }
            }
        ).liveData
    }
}