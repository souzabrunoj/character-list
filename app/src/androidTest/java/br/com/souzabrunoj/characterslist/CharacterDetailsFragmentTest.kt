package br.com.souzabrunoj.characterslist

import android.os.Bundle
import br.com.souzabrunoj.characterslist.dataRemote.details.response.CharacterDetailsResponse
import br.com.souzabrunoj.characterslist.details.onLaunch
import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails
import br.com.souzabrunoj.characterslist.domain.data.details.toDomain
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import br.com.souzabrunoj.characterslist.uitls.BaseTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.dsl.module
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import utils.fromJson


@OptIn(ExperimentalCoroutinesApi::class)
class CharacterDetailsFragmentTest : BaseTest() {

    private val repository: CharacterDetailsRepository = mock()

    override val mocks = listOf(repository)

    override val testDependenciesModules = module { single { repository } }.toList()

    @Test
    fun when_is_success_get_character_should_display_data() {
        val bundle = Bundle().apply {
            putInt("characterId", 1)
            putString("characterName", "Morty Smith")
        }
        stubSuccessGetCharacter()
        onLaunch(bundle = bundle) {
            checkCharacterData()
        }
    }

    @Test
    fun when_is_error_get_character_should_display_data() {
        val bundle = Bundle().apply {
            putInt("characterId", 1)
            putString("characterName", "Morty Smith")
        }
        stubErrorGetCharacter()
        onLaunch(bundle = bundle) {
            Thread.sleep(2000)
            checkErrorState()
        }
    }

    private fun stubSuccessGetCharacter() = runBlocking {
        val data: CharacterDetails = fromJson<CharacterDetailsResponse>(
            "details/success_get_character_details.json"
        ).toDomain()
        `when`(repository.getCharacterDetails(1)).thenReturn(Result.success(data))
    }
    private fun stubErrorGetCharacter() = runBlocking {
        `when`(repository.getCharacterDetails(1)).thenReturn(Result.failure(Throwable()))
    }
}
