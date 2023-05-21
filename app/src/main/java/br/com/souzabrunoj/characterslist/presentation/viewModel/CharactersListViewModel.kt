package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.souzabrunoj.characterslist.data.list.response.CharacterResultResponse
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersListRepository
import kotlinx.coroutines.launch

class CharactersListViewModel(private val repository: CharactersListRepository) : ViewModel() {

    private val characterMutableLiveData = MutableLiveData<List<CharacterResultResponse>>()
    val characterLiveData: LiveData<List<CharacterResultResponse>> = characterMutableLiveData


    fun getCharacters() {
        viewModelScope.launch {
            repository.getCharactersList().apply {
                characterMutableLiveData.value = this.results
            }
        }
    }
}
