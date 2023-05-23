package br.com.souzabrunoj.characterslist.domain.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import br.com.souzabrunoj.characterslist.data.list.service.CharactersListService
import br.com.souzabrunoj.characterslist.dataLocal.CharacterRemoteKeysLocal
import br.com.souzabrunoj.characterslist.dataLocal.dataBase.CharacterListDataBase
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult
import br.com.souzabrunoj.characterslist.domain.data.list.toDomain

@ExperimentalPagingApi
class CharacterListRemoteMediator(
    private val dataRemote: CharactersListService,
    private val dataLocal: CharacterListDataBase
) : RemoteMediator<Int, CharactersListResult>() {

    private val characterDao = dataLocal.charactersDao()
    private val characterRemoteKeyDao = dataLocal.charactersRemoteKeysDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, CharactersListResult>): MediatorResult {
        return try {

            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosesToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }
            val response = dataRemote.getCharacterList(currentPage).toDomain()
            val endOfPagination = response.totalPages == currentPage

            val prevPage = if (currentPage == 1) null else currentPage.minus(1)
            val nextPage = if (endOfPagination) null else currentPage.plus(1)

            dataLocal.withTransaction {

                if (loadType == LoadType.REFRESH) {
                    characterDao.deleteCharacters()
                    characterRemoteKeyDao.deleteAllRemoteKeys()
                }

                characterDao.addCharacters(response.results)

                val keys = response.results.map {
                    CharacterRemoteKeysLocal(
                        id = it.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                characterRemoteKeyDao.addAllRemoteKeys(keys)

                MediatorResult.Success(endOfPagination)
            }
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosesToCurrentPosition(state: PagingState<Int, CharactersListResult>): CharacterRemoteKeysLocal? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id -> characterRemoteKeyDao.getRemoteKey(id) }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, CharactersListResult>): CharacterRemoteKeysLocal? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let {
            characterRemoteKeyDao.getRemoteKey(it.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, CharactersListResult>): CharacterRemoteKeysLocal? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let {
            characterRemoteKeyDao.getRemoteKey(it.id)
        }
    }
}