package br.com.souzabrunoj.characterslist.domain.repository.details

import br.com.souzabrunoj.characterslist.data.details.service.CharacterDetailsService
import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails
import br.com.souzabrunoj.characterslist.domain.data.details.toDomain

class CharacterDetailsRepositoryImpl(private val service: CharacterDetailsService) : CharacterDetailsRepository {

    override suspend fun getCharacterDetails(characterId: Int): CharacterDetails {
        return service.getCharacterDetails(characterId).toDomain()
    }
}