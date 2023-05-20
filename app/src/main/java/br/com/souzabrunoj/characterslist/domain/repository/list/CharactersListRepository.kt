package br.com.souzabrunoj.characterslist.domain.repository.list

import br.com.souzabrunoj.characterslist.data.list.response.CharactersResponse

interface CharactersListRepository {

    suspend fun getCharactersList(): CharactersResponse
}