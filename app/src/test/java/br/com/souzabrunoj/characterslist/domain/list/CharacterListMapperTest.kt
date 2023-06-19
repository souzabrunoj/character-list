package br.com.souzabrunoj.characterslist.domain.list

import br.com.souzabrunoj.characterslist.dataRemote.list.response.CharactersListResponse
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersList
import br.com.souzabrunoj.characterslist.domain.data.list.toDomain
import org.junit.Test
import utils.fromJson
import kotlin.test.assertEquals

class CharacterDetailsMapperTest {

    @Test
    fun `WHEN convert to domain layer MUST return correct values`() {
        val data: CharactersList = fromJson<CharactersListResponse>(
            "list/success_get_character_list.json"
        ).toDomain()

        val dataDomain: CharactersList = fromJson("list/domain_character_list.json")

        assertEquals(dataDomain, data)
    }

    @Test
    fun `WHEN convert to domain layer with null fields MUST return with default values`() {
        val data: CharactersList = fromJson<CharactersListResponse>(
            "list/success_get_character_list_all_fields_null.json"
        ).toDomain()

        val dataDomain: CharactersList = fromJson(
            "list/success_get_character_list_default_values.json"
        )

        assertEquals(dataDomain, data)
    }
}
