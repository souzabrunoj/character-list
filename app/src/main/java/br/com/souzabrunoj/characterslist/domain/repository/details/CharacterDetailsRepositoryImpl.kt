package br.com.souzabrunoj.characterslist.domain.repository.details

import br.com.souzabrunoj.characterslist.data.apiCall
import br.com.souzabrunoj.characterslist.data.details.service.CharacterDetailsService
import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails
import br.com.souzabrunoj.characterslist.domain.data.details.toDomain

class CharacterDetailsRepositoryImpl(private val service: CharacterDetailsService) : CharacterDetailsRepository {

    override suspend fun getCharacterDetails(characterId: Int): Result<CharacterDetails> =
        apiCall { service.getCharacterDetails(characterId) }.map { it.toDomain() }

}