package br.com.souzabrunoj.movielist.base

import android.app.Application
import br.com.souzabrunoj.movielist.di.presentationModule
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
                    presentationModule
                )
            )
        }
    }
}