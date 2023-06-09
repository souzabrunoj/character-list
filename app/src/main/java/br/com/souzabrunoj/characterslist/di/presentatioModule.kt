package br.com.souzabrunoj.characterslist.di

import br.com.souzabrunoj.characterslist.presentation.viewModel.CharacterDetailsViewModel
import br.com.souzabrunoj.characterslist.presentation.viewModel.CharactersListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CharactersListViewModel(get()) }
    viewModel { CharacterDetailsViewModel(get()) }
}