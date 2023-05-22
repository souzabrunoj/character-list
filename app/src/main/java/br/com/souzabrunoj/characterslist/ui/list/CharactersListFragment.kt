package br.com.souzabrunoj.characterslist.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.souzabrunoj.characterslist.R
import br.com.souzabrunoj.characterslist.data.list.response.CharactersListResultResponse
import br.com.souzabrunoj.characterslist.databinding.FragmentCharactersListBinding
import br.com.souzabrunoj.characterslist.presentation.viewModel.CharactersListViewModel
import br.com.souzabrunoj.characterslist.ui.list.adatper.CharacterLoadingStateAdapter
import br.com.souzabrunoj.characterslist.ui.list.adatper.CharacterPagingAdapter
import br.com.souzabrunoj.characterslist.ui.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersListFragment : Fragment(R.layout.fragment_characters_list) {

    private val binding: FragmentCharactersListBinding by viewBinding()
    private val viewModel: CharactersListViewModel by viewModel()
    private val navController: NavController by lazy { findNavController() }
    private val pagingAdapter: CharacterPagingAdapter by lazy { CharacterPagingAdapter(::onItemClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvNextScreen.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = pagingAdapter.withLoadStateHeaderAndFooter(
                header = CharacterLoadingStateAdapter { pagingAdapter.retry() },
                footer = CharacterLoadingStateAdapter { pagingAdapter.retry() }
            )
        }
    }

    private fun setupObservers() {
        viewModel.getCharacters().observe(viewLifecycleOwner) { characters ->
            pagingAdapter.submitData(lifecycle, characters)
        }
    }

    private fun onItemClick(item: CharactersListResultResponse) {
        navController.navigate(
            CharactersListFragmentDirections.actionFromCharacterListToCharacterDetailsFragment(item.id, item.name)
        )
    }
}