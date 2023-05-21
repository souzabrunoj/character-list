package br.com.souzabrunoj.characterslist.domain.repository.details

import br.com.souzabrunoj.characterslist.data.details.response.CharacterDetailsResponse
import br.com.souzabrunoj.characterslist.data.details.service.CharacterDetailsService

class CharacterDetailsRepositoryImpl(private val service: CharacterDetailsService) : CharacterDetailsRepository {

    override suspend fun getCharacterDetails(characterId: Int): CharacterDetailsResponse {
        return service.getCharacterDetails(characterId)
    }
}