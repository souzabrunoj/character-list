package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.souzabrunoj.characterslist.data.list.response.CharactersResponse
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersListRepository
import kotlinx.coroutines.launch

class CharactersListViewModel(private val repository: CharactersListRepository) : ViewModel() {

    private lateinit var character: CharactersResponse

    fun getCharacters() {
        viewModelScope.launch {
            repository.getCharactersList().apply {
                character = this
            }
        }
    }

    fun getCharacterId() = character
}
