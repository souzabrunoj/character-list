package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersPagingListRepository
import br.com.souzabrunoj.characterslist.domain.utlis.EMPTY_STRING

class CharactersListViewModel(private val repositoryPaging: CharactersPagingListRepository) : ViewModel(), LifecycleObserver {


    private var nameFilter = EMPTY_STRING
    private var statusFilter = EMPTY_STRING

    private val _filter = MutableLiveData<Unit>()
    val filter: MutableLiveData<Unit> = _filter

    fun getCharacters() = repositoryPaging.getCharactersList(nameFilter, statusFilter).cachedIn(viewModelScope)

    fun updateFilter(name: String = EMPTY_STRING, status: String = EMPTY_STRING) {
        nameFilter = name
        statusFilter = status
        _filter.value = Unit
    }
}

