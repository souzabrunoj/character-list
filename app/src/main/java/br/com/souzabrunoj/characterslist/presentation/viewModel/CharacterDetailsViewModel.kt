package br.com.souzabrunoj.characterslist.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails
import br.com.souzabrunoj.characterslist.domain.repository.details.CharacterDetailsRepository
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(
    private val repository: CharacterDetailsRepository
) : ViewModel() {

    private val _character = MutableLiveData<CharacterDetails>()
    val character: LiveData<CharacterDetails> = _character

    private val _error = MutableLiveData<Unit>()
    val error: LiveData<Unit> = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getCharacters(characterId: Int) {
        _loading.value = true
        viewModelScope.launch {
            repository.getCharacterDetails(characterId)
                .onSuccess {
                    _loading.value = false
                    _character.value = it
                }
                .onFailure {
                    _loading.value = false
                    _error.value = Unit
                }
        }
    }
}
