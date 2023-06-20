package br.com.souzabrunoj.characterslist.uitls

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import br.com.souzabrunoj.characterslist.di.dataLocalModule
import br.com.souzabrunoj.characterslist.di.dataRemoteModule
import br.com.souzabrunoj.characterslist.di.domainModule
import br.com.souzabrunoj.characterslist.di.presentationModule
import io.mockk.clearAllMocks
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.extension.RegisterExtension
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule

open class BaseTest : KoinTest {

    private val testContext: Context by lazy { ApplicationProvider.getApplicationContext() }

    val navController by lazy { TestNavHostController(testContext) }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    protected open val testDependenciesModules: List<Module> = listOf()

    @JvmField
    @RegisterExtension
    val koinTest = KoinTestRule.create {
        androidLogger(Level.DEBUG)
        androidContext(testContext)
        modules(
            presentationModule
                    + domainModule
                    + dataRemoteModule
                    + dataLocalModule
                    + testDependenciesModules
        )
    }

    @Before
    open fun setup() {
    }

    @After
    open fun tearDown() {
        stopKoin()
        clearAllMocks()
    }

    protected fun Module.toList() = listOf(this)
}