package br.com.souzabrunoj.characterslist.di

import br.com.souzabrunoj.characterslist.dataLocal.dataBase.CharacterDataBaseFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {
    single { CharacterDataBaseFactory(androidContext()).dataBase }
}