package br.com.souzabrunoj.characterslist.viewModel

import androidx.lifecycle.ViewModel
import java.lang.Integer.sum

class CharactersListViewModel : ViewModel() {

    fun sumTwoNumbers(num1: Int, num2: Int): Int {
        return if (num1 < 0) {
            num1 - num2
        } else {
            sum(num1, num2)
        }
    }
}
