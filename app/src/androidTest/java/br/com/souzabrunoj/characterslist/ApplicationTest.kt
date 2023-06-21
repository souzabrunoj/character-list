package br.com.souzabrunoj.characterslist

import android.app.Application
import br.com.souzabrunoj.characterslist.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class ApplicationTest : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationTest)
            modules(presentationModule)
        }
    }
}