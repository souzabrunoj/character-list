package br.com.souzabrunoj.characterslist.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.souzabrunoj.characterslist.databinding.ItemCharacterEpisodesBinding

class CharacterEpisodesAdapter(private val locations: List<String>) :
    RecyclerView.Adapter<CharacterEpisodesAdapter.CharacterEpisodesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterEpisodesViewHolder {
        return CharacterEpisodesViewHolder(ItemCharacterEpisodesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = locations.count()

    override fun onBindViewHolder(holder: CharacterEpisodesViewHolder, position: Int) {
        holder.setupItem(locations[position])
    }

    inner class CharacterEpisodesViewHolder(
        private val view: ItemCharacterEpisodesBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun setupItem(item: String) {
            view.apply {
                tvEpisodeName.text = item
            }
        }
    }
}