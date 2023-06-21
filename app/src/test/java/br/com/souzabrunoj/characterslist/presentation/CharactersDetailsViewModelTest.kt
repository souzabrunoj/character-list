package br.com.souzabrunoj.characterslist.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.souzabrunoj.characterslist.dataRemote.details.response.CharacterDetailsResponse
import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails
import br.com.souzabrunoj.characterslist.domain.data.details.toDomain
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import br.com.souzabrunoj.characterslist.presentation.viewModel.CharacterDetailsViewModel
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verifySequence
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import org.koin.mp.KoinPlatform.startKoin
import utils.fromJson
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class CharactersDetailsViewModelTest {

    private lateinit var viewModel: CharacterDetailsViewModel
    private val repository: CharacterDetailsRepository = mockk()

    private val testModule = module { single { repository } }

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        startKoin(modules = listOf(testModule), level = Level.ERROR)
        viewModel = CharacterDetailsViewModel(repository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun reset() {
        stopKoin()
        Dispatchers.resetMain()
    }

    @Test
    fun `WHEN get character details is success MUST post success`() {
        val data = stubGetCharacterSuccess()
        viewModel.getCharacters(1)
        coVerify(exactly = 1) { repository.getCharacterDetails(1) }
        assertEquals(data, viewModel.character.value)
        assertEquals(null, viewModel.error.value)
        assertEquals(false, viewModel.loading.value)
    }

    @Test
    fun `WHEN get character details is fail MUST post error`() {

        coEvery { repository.getCharacterDetails(1) } coAnswers { Result.failure(Error()) }
        viewModel.getCharacters(1)

        coVerify(exactly = 1) { repository.getCharacterDetails(1) }
        assertEquals(true, viewModel.error.value)
        assertEquals(null, viewModel.character.value)
    }

    @Test
    fun `WHEN get character details is fail MUST post correct sequence loading state`() {
        val observer = mockk<Observer<Boolean>> { every { onChanged(any()) } just Runs }

        stubGetCharacterSuccess()
        viewModel.loading.observeForever(observer)
        viewModel.getCharacters(1)

        verifySequence {
            observer.onChanged(true)
            observer.onChanged(false)
        }
    }

    private fun stubGetCharacterSuccess(): CharacterDetails {
        val data: CharacterDetails = fromJson<CharacterDetailsResponse>(
            "details/success_get_character_details.json"
        ).toDomain()

        coEvery { repository.getCharacterDetails(1) } coAnswers { Result.success(data) }
        return data
    }
}

