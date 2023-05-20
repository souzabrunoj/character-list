package br.com.souzabrunoj.characterslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.souzabrunoj.characterslist.databinding.FragmentCharactersListBinding
import br.com.souzabrunoj.characterslist.viewModel.CharactersListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersListFragment : Fragment() {

    private lateinit var binding: FragmentCharactersListBinding
    private val viewModel: CharactersListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharactersListBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

}