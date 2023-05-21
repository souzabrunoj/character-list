package br.com.souzabrunoj.characterslist.ui.utils.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.souzabrunoj.characterslist.R
import br.com.souzabrunoj.characterslist.data.details.response.CharacterDetailsResponse
import br.com.souzabrunoj.characterslist.databinding.FragmentCharacterDetailsBinding
import br.com.souzabrunoj.characterslist.presentation.viewModel.CharacterDetailsViewModel
import br.com.souzabrunoj.characterslist.ui.utils.details.adapter.CharacterEpisodesAdapter
import br.com.souzabrunoj.characterslist.ui.utils.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailsBinding
    private val viewModel: CharacterDetailsViewModel by viewModel()
    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharacterDetailsBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacters(args.characterId)
        setupActionBarTitle()
        addObservers()
    }

    private fun addObservers() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) { character ->
            setupCharacter(character)
        }
    }

    private fun setupActionBarTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = args.characterName
    }

    private fun setupCharacter(character: CharacterDetailsResponse) {
        binding.apply {
            with(character) {
                ivCharacterImage.loadImage(image)
                tvName.text = getString(R.string.character_name_string_format, name)
                tvStatus.text = getString(R.string.character_status_string_format, status)
                tvSpecies.text = getString(R.string.character_species_string_format, species)
                tvGender.text = getString(R.string.character_gender_string_format, gender)
                tvLocation.text = getString(R.string.location_string_format, location.name)
            }
        }
        setupLocations(character.episode)
    }

    private fun setupLocations(locations: List<String>) {
        binding.rvEpisodes.apply {
            adapter = CharacterEpisodesAdapter(locations)
        }
    }
}