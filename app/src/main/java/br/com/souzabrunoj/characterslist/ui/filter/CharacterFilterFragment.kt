package br.com.souzabrunoj.characterslist.ui.filter

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.souzabrunoj.characterslist.R
import br.com.souzabrunoj.characterslist.databinding.FragmentCharacterFilterBinding
import br.com.souzabrunoj.characterslist.domain.utlis.EMPTY_STRING
import br.com.souzabrunoj.characterslist.presentation.viewModel.CharactersListViewModel
import br.com.souzabrunoj.characterslist.ui.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class CharacterFilterFragment : Fragment(R.layout.fragment_character_filter) {

    private val binding: FragmentCharacterFilterBinding by viewBinding()
    private val viewModel: CharactersListViewModel by activityViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
    }

    private fun setListeners() {
        binding.btSubmitFilter.setOnClickListener { applyFilter() }

        binding.btSubmitFilter.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                applyFilter()
                true
            } else {
                false
            }
        }
    }

    private fun getFilter(): String {
        return when (binding.cgFilters.checkedChipId) {
            R.id.chip_alive -> getString(R.string.alive)
            R.id.chip_dead -> getString(R.string.dead)
            R.id.chip_unknown -> getString(R.string.unknown)
            else -> EMPTY_STRING
        }
    }

    private fun applyFilter() {
        viewModel.updateFilter(
            name = binding.input.text.toString(),
            status = getFilter()
        )
        findNavController().popBackStack()
    }
}

