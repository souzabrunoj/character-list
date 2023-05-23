package br.com.souzabrunoj.characterslist.domain.repository.list

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult

interface CharactersPagingListRepository {

    fun getCharactersList(name: String, status: String): LiveData<PagingData<CharactersListResult>>
}