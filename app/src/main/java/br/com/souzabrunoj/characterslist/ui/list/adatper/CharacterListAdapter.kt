package br.com.souzabrunoj.characterslist.ui.list.adatper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.souzabrunoj.characterslist.data.list.response.CharacterResultResponse
import br.com.souzabrunoj.characterslist.databinding.ItemCharacterListBinding
import br.com.souzabrunoj.characterslist.ui.utils.loadImage

private typealias onItemClick = (CharacterResultResponse) -> Unit

class CharacterListAdapter(
    private val characters: List<CharacterResultResponse>, private val onItemClick: onItemClick
    ) : RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder(
            ItemCharacterListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = characters.count()

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.setupItem(characters[position])
    }

    inner class CharacterListViewHolder(
        private val view: ItemCharacterListBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun setupItem(item: CharacterResultResponse) {
            view.apply {
                ivCharacterImageItemList.loadImage(item.image)
                tvCharacterNameItemList.text = item.name

                root.setOnClickListener { onItemClick(item) }
            }
        }
    }
}