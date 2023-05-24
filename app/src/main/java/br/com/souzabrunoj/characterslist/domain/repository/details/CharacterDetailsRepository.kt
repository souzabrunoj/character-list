package br.com.souzabrunoj.characterslist.domain.repository.details

import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails

interface CharacterDetailsRepository {

    suspend fun getCharacterDetails(characterId: Int): Result<CharacterDetails>
}