package br.com.souzabrunoj.characterslist.base

import android.app.Application
import br.com.souzabrunoj.characterslist.di.dataLocalModule
import br.com.souzabrunoj.characterslist.di.dataRemoteModule
import br.com.souzabrunoj.characterslist.di.domainModule
import br.com.souzabrunoj.characterslist.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                listOf(
                    presentationModule,
                    domainModule,
                    dataRemoteModule, dataLocalModule
                )
            )
        }
    }
}