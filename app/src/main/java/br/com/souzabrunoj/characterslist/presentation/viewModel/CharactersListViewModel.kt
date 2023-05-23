package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersPagingListRepository
import br.com.souzabrunoj.characterslist.domain.utlis.EMPTY_STRING

class CharactersListViewModel(private val repositoryPaging: CharactersPagingListRepository) : ViewModel(), LifecycleObserver {

    private val nameFilterMutableLiveData = MutableLiveData(EMPTY_STRING)
    val nameFilterLiveData: LiveData<String> = nameFilterMutableLiveData

    private val statusFilterMutableLiveData = MutableLiveData(EMPTY_STRING)
    val statusFilterLiveData: LiveData<String> = statusFilterMutableLiveData

    fun getCharacters() = repositoryPaging.getCharactersList().cachedIn(viewModelScope)
}

