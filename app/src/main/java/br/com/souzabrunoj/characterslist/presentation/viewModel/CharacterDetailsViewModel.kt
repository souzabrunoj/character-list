package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.souzabrunoj.characterslist.data.details.response.CharacterDetailsResponse
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(private val repository: CharacterDetailsRepository) : ViewModel() {

    private val characterMutableLiveData = MutableLiveData<CharacterDetailsResponse>()
    val characterLiveData: LiveData<CharacterDetailsResponse> = characterMutableLiveData

    fun getCharacters(characterId: Int) {
        viewModelScope.launch {
            characterMutableLiveData.value = repository.getCharacterDetails(characterId)
        }
    }
}
