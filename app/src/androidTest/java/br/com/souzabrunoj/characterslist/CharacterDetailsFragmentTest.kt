package br.com.souzabrunoj.characterslist

import android.os.Bundle
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import br.com.souzabrunoj.characterslist.uitls.BaseTest
import br.com.souzabrunoj.characterslist.uitls.onLaunch
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.koin.dsl.module


@OptIn(ExperimentalCoroutinesApi::class)
class CharacterDetailsFragmentTest : BaseTest() {

    private val repository: CharacterDetailsRepository = mockk(relaxed = true)

    override val testDependenciesModules = module { single { repository } }.toList()

    override fun setup() {
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
            override fun postToMainThread(runnable: Runnable) = runnable.run()
            override fun isMainThread(): Boolean = true
        })
    }

    @Test
    fun test() {
        val bundle = Bundle().apply {
            putInt("characterId", 1)
        }
        onLaunch(bundle = bundle) {
            onView(withId(R.id.tv_name)).check(matches(withText("Morty Smith")))
        }
    }
}
