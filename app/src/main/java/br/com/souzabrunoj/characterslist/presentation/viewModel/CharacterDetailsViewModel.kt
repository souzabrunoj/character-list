package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(private val repository: CharacterDetailsRepository) : ViewModel() {

    fun getCharacters(characterId: String) {
        viewModelScope.launch {
            repository.getCharacterDetails(characterId)
        }
    }
}
