package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersPagingListRepository

class CharactersListViewModel(private val repositoryPaging: CharactersPagingListRepository) : ViewModel() ,LifecycleObserver{

    fun getCharacters() = repositoryPaging.getCharactersList().cachedIn(viewModelScope)

}
