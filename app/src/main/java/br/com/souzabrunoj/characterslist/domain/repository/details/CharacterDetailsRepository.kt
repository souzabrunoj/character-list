package br.com.souzabrunoj.characterslist.domain.repository.details

import br.com.souzabrunoj.characterslist.data.details.response.CharacterDetailsResponse

interface CharacterDetailsRepository {

    suspend fun getCharacterDetails(characterId: String): CharacterDetailsResponse
}