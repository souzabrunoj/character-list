package br.com.souzabrunoj.characterslist.ui.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.souzabrunoj.characterslist.R
import br.com.souzabrunoj.characterslist.databinding.FragmentCharactersListBinding
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult
import br.com.souzabrunoj.characterslist.domain.utlis.ZERO
import br.com.souzabrunoj.characterslist.presentation.viewModel.CharactersListViewModel
import br.com.souzabrunoj.characterslist.ui.list.adatper.CharacterLoadingStateAdapter
import br.com.souzabrunoj.characterslist.ui.list.adatper.CharacterPagingAdapter
import br.com.souzabrunoj.characterslist.ui.utils.viewBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class CharactersListFragment : Fragment(R.layout.fragment_characters_list) {

    private val binding: FragmentCharactersListBinding by viewBinding()
    private val viewModel: CharactersListViewModel by activityViewModel()
    private val navController: NavController by lazy { findNavController() }
    private val pagingAdapter: CharacterPagingAdapter by lazy { CharacterPagingAdapter(::onItemClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupRecyclerView()
        setupMenu()
    }

    private fun setupRecyclerView() {
        binding.rvNextScreen.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pagingAdapter.withLoadStateHeaderAndFooter(
                header = CharacterLoadingStateAdapter(pagingAdapter),
                footer = CharacterLoadingStateAdapter(pagingAdapter)
            )
        }
        setOnLoadStateInList()
    }

    private fun setOnLoadStateInList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                pagingAdapter.loadStateFlow.collectLatest { loadStates ->
                    showEmptyState(loadStates.refresh is LoadState.Error)
                    showLoadingState(
                        loadStates.refresh is LoadState.Loading && pagingAdapter.itemCount == ZERO
                    )
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                pagingAdapter.loadStateFlow
                    .distinctUntilChangedBy { it.refresh }
                    .filter { it.refresh is LoadState.NotLoading }
                    .collect { binding.rvNextScreen.scrollToPosition(0) }
            }
        }
    }

    private fun showEmptyState(isShow: Boolean) {
        binding.iEmptyState.errorMsg.isVisible = isShow
        binding.iEmptyState.errorMsg.text = getString(R.string.search_not_result)
        binding.iEmptyState.root.isVisible = isShow
    }

    private fun showLoadingState(isShow: Boolean) {
        binding.iLoading.root.isVisible = isShow
    }

    private fun setupObservers() {
        viewModel.getCharacters().observe(viewLifecycleOwner) { characters ->
            pagingAdapter.submitData(lifecycle, characters)
        }

        viewModel.filterLiveData.observe(viewLifecycleOwner) {
            viewModel.getCharacters()
        }
    }

    private fun onItemClick(item: CharactersListResult) {
        navController.navigate(
            CharactersListFragmentDirections.actionFromCharacterListToCharacterDetailsFragment(item.id, item.name)
        )
    }

    private fun setupMenu() {
        activity?.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.filter_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return NavigationUI.onNavDestinationSelected(menuItem, findNavController())
            }
        }, viewLifecycleOwner)
    }
}