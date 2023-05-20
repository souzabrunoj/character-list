package br.com.souzabrunoj.movielist.di

import br.com.souzabrunoj.movielist.viewModel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MainActivityViewModel() }
}