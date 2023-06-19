package br.com.souzabrunoj.characterslist.domain.details

import br.com.souzabrunoj.characterslist.dataRemote.details.response.CharacterDetailsResponse
import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails
import br.com.souzabrunoj.characterslist.domain.data.details.toDomain
import org.junit.Test
import utils.fromJson
import kotlin.test.assertEquals

class CharacterDetailsMapperTest {

    @Test
    fun `WHEN convert to domain layer MUST return correct values`() {
        val data: CharacterDetails = fromJson<CharacterDetailsResponse>(
            "details/success_get_character_details.json"
        ).toDomain()

        val dataDomain: CharacterDetails = fromJson(
            "details/success_get_character_details.json"
        )

        assertEquals(dataDomain, data)
    }

    @Test
    fun `WHEN convert to domain layer with null fields MUST return with default values`() {
        val data: CharacterDetails = fromJson<CharacterDetailsResponse>(
            "details/success_get_character_details_all_fields_null.json"
        ).toDomain()

        val dataDomain: CharacterDetails = fromJson(
            "details/success_get_character_details_default_values.json"
        )

        assertEquals(dataDomain, data)
    }
}
