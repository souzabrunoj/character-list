package br.com.souzabrunoj.characterslist.di

import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepositoryImpl
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersListRepository
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersListRepositoryImpl
import org.koin.dsl.module

val domainModule = module {
    factory<CharactersListRepository> { CharactersListRepositoryImpl(get()) }
    factory<CharacterDetailsRepository> { CharacterDetailsRepositoryImpl(get()) }
}