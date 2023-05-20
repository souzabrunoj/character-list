package br.com.souzabrunoj.characterslist.domain.repository.list

import br.com.souzabrunoj.characterslist.data.list.response.CharactersResponse
import br.com.souzabrunoj.characterslist.data.list.service.CharactersListService

class CharactersListRepositoryImpl(private val service: CharactersListService) : CharactersListRepository {
    override suspend fun getCharactersList(): CharactersResponse {
        return service.getCharacterList()
    }
}