package br.com.souzabrunoj.characterslist.di

import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepositoryImpl
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersPagingListRepository
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersPagingListRepositoryImpl
import org.koin.dsl.module

val domainModule = module {
    factory<CharacterDetailsRepository> { CharacterDetailsRepositoryImpl(get()) }

    factory<CharactersPagingListRepository> { (name: String, status: String) ->
        CharactersPagingListRepositoryImpl(dataRemote = get(), dataLocal = get(), name = name, status = status)
    }
}