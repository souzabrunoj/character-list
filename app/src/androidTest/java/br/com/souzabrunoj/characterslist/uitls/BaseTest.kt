package br.com.souzabrunoj.characterslist.uitls

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.test.KoinTest
import org.mockito.Mockito.reset

open class BaseTest : KoinTest {

     open val testContext: Context by lazy { ApplicationProvider.getApplicationContext() }

    val navController by lazy { TestNavHostController(testContext) }

    open val mocks = listOf<Any>()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    open val testDependenciesModules = listOf<Module>()

    @Before
    open fun setup() {
        loadKoinModules(testDependenciesModules)
    }

    @After
    open fun tearDown() {
        unloadKoinModules(testDependenciesModules)
        mocks.forEach { reset(it) }
    }

    protected fun Module.toList() = listOf(this)
}