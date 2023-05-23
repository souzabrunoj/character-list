package br.com.souzabrunoj.characterslist.ui.list.adatper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.souzabrunoj.characterslist.databinding.ItemCharacterLoadingStateFooterBinding

class CharacterLoadingStateAdapter(
    private val adapter: CharacterPagingAdapter
) : LoadStateAdapter<CharacterLoadingStateAdapter.CharacterLoadingStateViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): CharacterLoadingStateViewHolder {
        return CharacterLoadingStateViewHolder(
            ItemCharacterLoadingStateFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterLoadingStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    inner class CharacterLoadingStateViewHolder(
        private val binding: ItemCharacterLoadingStateFooterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.errorMsg.text = loadState.error.localizedMessage
            }
            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.retryButton.isVisible = loadState is LoadState.Error
            binding.errorMsg.isVisible = loadState is LoadState.Error
            binding.retryButton.setOnClickListener { adapter.retry() }
        }
    }
}
