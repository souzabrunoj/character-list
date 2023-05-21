package br.com.souzabrunoj.characterslist.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import br.com.souzabrunoj.characterslist.R
import br.com.souzabrunoj.characterslist.data.list.response.CharacterResultResponse
import br.com.souzabrunoj.characterslist.databinding.FragmentCharactersListBinding
import br.com.souzabrunoj.characterslist.presentation.viewModel.CharactersListViewModel
import br.com.souzabrunoj.characterslist.ui.list.adatper.CharacterListAdapter
import br.com.souzabrunoj.characterslist.ui.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersListFragment : Fragment(R.layout.fragment_characters_list) {

    private val binding: FragmentCharactersListBinding by viewBinding()
    private val viewModel: CharactersListViewModel by viewModel()
    private val navController: NavController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharacters()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) { characters ->
            binding.rvNextScreen.apply {
                adapter = CharacterListAdapter(characters, ::onItemClick)
            }
        }
    }

    private fun onItemClick(item: CharacterResultResponse) {
        navController.navigate(
            CharactersListFragmentDirections.actionFromCharacterListToCharacterDetailsFragment(item.id, item.name)
        )
    }
}