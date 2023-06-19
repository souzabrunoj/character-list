package br.com.souzabrunoj.characterslist.presentation.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.souzabrunoj.characterslist.databinding.ItemCharacterEpisodesBinding
import br.com.souzabrunoj.characterslist.presentation.ui.utils.underline

private typealias onItemClick = (String) -> Unit

class CharacterEpisodesAdapter(private val episodes: List<String>, private val onItemClick: onItemClick) :
    RecyclerView.Adapter<CharacterEpisodesAdapter.CharacterEpisodesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterEpisodesViewHolder {
        return CharacterEpisodesViewHolder(
            ItemCharacterEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = episodes.count()

    override fun onBindViewHolder(holder: CharacterEpisodesViewHolder, position: Int) {
        holder.setupItem(episodes[position])
    }

    inner class CharacterEpisodesViewHolder(
        private val view: ItemCharacterEpisodesBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun setupItem(item: String) {
            view.apply {
                tvEpisodeName.text = item
                tvEpisodeName.underline()

                root.setOnClickListener { onItemClick(item) }
            }
        }
    }
}