package br.com.souzabrunoj.characterslist.domain.repository.list

import androidx.paging.Pager
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult

interface CharactersPagingListRepository {

    fun getCharactersList(name: String, status: String): Pager<Int, CharactersListResult>
}