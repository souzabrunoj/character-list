package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.souzabrunoj.characterslist.domain.repository.list.CharactersListRepository
import kotlinx.coroutines.launch

class CharactersListViewModel(private val repository: CharactersListRepository) : ViewModel() {

    private var characterId = ""

    fun getCharacters() {
        viewModelScope.launch {
            repository.getCharactersList().apply {
                characterId = this.results[0].id.toString()
            }
        }
    }

    fun getCharacterId() = characterId
}
