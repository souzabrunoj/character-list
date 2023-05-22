package br.com.souzabrunoj.characterslist.di

import br.com.souzabrunoj.characterslist.data.factory.ServiceClientFactory
import br.com.souzabrunoj.characterslist.data.factory.ServiceClientFactory.createClient
import br.com.souzabrunoj.characterslist.data.details.service.CharacterDetailsService
import br.com.souzabrunoj.characterslist.data.list.service.CharactersListService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module

private const val BASE_URL ="https://rickandmortyapi.com/api/"

val dataRemoteModule = module {

    single { createClient<CharactersListService>(BASE_URL, get(), get()) }
    single { createClient<CharacterDetailsService>(BASE_URL, get(), get()) }

    single { ServiceClientFactory.createOkHttpClient() }
    factory { CoroutineCallAdapterFactory() }
}