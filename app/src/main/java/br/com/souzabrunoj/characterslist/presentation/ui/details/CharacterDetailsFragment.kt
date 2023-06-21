package br.com.souzabrunoj.characterslist.presentation.ui.details

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.souzabrunoj.characterslist.R
import br.com.souzabrunoj.characterslist.databinding.FragmentCharacterDetailsBinding
import br.com.souzabrunoj.characterslist.domain.data.details.CharacterDetails
import br.com.souzabrunoj.characterslist.presentation.ui.details.adapter.CharacterEpisodesAdapter
import br.com.souzabrunoj.characterslist.presentation.ui.utils.loadImage
import br.com.souzabrunoj.characterslist.presentation.ui.utils.viewBinding
import br.com.souzabrunoj.characterslist.presentation.viewModel.CharacterDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    private val binding: FragmentCharacterDetailsBinding by viewBinding()
    private val viewModel: CharacterDetailsViewModel by viewModel()
    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacters(args.characterId)
        setupActionBarTitle()
        addObservers()
    }

    private fun addObservers() {
        viewModel.character.observe(viewLifecycleOwner) { character ->
            binding.clContainerView.isVisible = true
            setupCharacter(character)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            binding.tvErrorMassage.isVisible = true
            binding.clContainerView.isVisible = false
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            with(binding) {
                iLoading.root.isVisible = isLoading
                clContainerView.isVisible = !isLoading
            }
        }
    }

    private fun setupActionBarTitle() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = args.characterName
    }

    private fun setupCharacter(character: CharacterDetails) {
        binding.apply {
            with(character) {
                ivCharacterImage.loadImage(image)
                tvCharacterName.text = name
                tvStatus.text = getString(R.string.character_status_string_format, status)
                tvSpecies.text = getString(R.string.character_species_string_format, species)
                tvGender.text = getString(R.string.character_gender_string_format, gender)
                tvLocation.text = getString(R.string.location_string_format, location.name)
            }
        }
        setupEpisodes(character.episode)
    }

    private fun setupEpisodes(episodes: List<String>) {
        binding.rvEpisodes.apply {
            adapter = CharacterEpisodesAdapter(episodes, ::openEpisodes)
        }
    }

    private fun openEpisodes(url: String) {
        CustomTabsIntent.Builder().build().apply {
            launchUrl(context, Uri.parse(url))
        }
    }
}