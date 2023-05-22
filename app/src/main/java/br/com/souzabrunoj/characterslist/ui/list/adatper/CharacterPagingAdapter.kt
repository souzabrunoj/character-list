package br.com.souzabrunoj.characterslist.ui.list.adatper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.souzabrunoj.characterslist.databinding.ItemCharacterListBinding
import br.com.souzabrunoj.characterslist.domain.data.list.CharactersListResult
import br.com.souzabrunoj.characterslist.ui.utils.loadImage

private typealias OnClick = (CharactersListResult) -> Unit

class CharacterPagingAdapter(
    private val onClick: OnClick
) : PagingDataAdapter<CharactersListResult,
        CharacterPagingAdapter.CharacterPagingAdapterViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterPagingAdapterViewHolder {
        return CharacterPagingAdapterViewHolder(
            ItemCharacterListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterPagingAdapterViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null)
            holder.setupItem(item)
    }

    inner class CharacterPagingAdapterViewHolder(
        private val binding: ItemCharacterListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setupItem(item: CharactersListResult) {
            binding.apply {
                ivCharacterImageItemList.loadImage(item.image)
                tvCharacterNameItemList.text = item.name

                root.setOnClickListener { onClick(item) }
            }
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<CharactersListResult>() {
        override fun areItemsTheSame(
            oldItem: CharactersListResult, newItem: CharactersListResult
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharactersListResult, newItem: CharactersListResult
        ): Boolean {
            return oldItem == newItem
        }
    }
}