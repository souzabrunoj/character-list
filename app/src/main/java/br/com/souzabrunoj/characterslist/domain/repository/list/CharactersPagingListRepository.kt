package br.com.souzabrunoj.characterslist.domain.repository.list

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import br.com.souzabrunoj.characterslist.data.list.response.CharacterResultResponse

interface CharactersPagingListRepository {

    fun getCharactersList(): LiveData<PagingData<CharacterResultResponse>>
}