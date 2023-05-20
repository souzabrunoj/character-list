package br.com.souzabrunoj.movielist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.souzabrunoj.movielist.databinding.FragmentCharactersListBinding

class CharactersListFragment : Fragment() {

    private lateinit var binding: FragmentCharactersListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCharactersListBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

}