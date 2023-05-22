package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(private val repository: CharacterDetailsRepository) : ViewModel() {

    private val characterMutableLiveData = MutableLiveData<CharacterDetails>()
    val characterLiveData: LiveData<CharacterDetails> = characterMutableLiveData

    fun getCharacters(characterId: Int) {
        viewModelScope.launch {
            characterMutableLiveData.value = repository.getCharacterDetails(characterId)
        }
    }
}
