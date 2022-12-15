package com.phinespec.moendemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.phinespec.moendemo.databinding.ItemsListItemBinding
import com.phinespec.moendemo.model.Item


class ItemListAdapter(private val itemClickListener: ItemClickListener) :
    ListAdapter<Item, ItemListAdapter.ItemViewHolder>(
        ItemListDiffCallBack()
    ) {

    inner class ItemViewHolder(val binding: ItemsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: ItemClickListener, item: Item) {
            binding.item = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemsListItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(itemClickListener, item)

    }

    class ItemListDiffCallBack : DiffUtil.ItemCallback<Item>() {

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.title == newItem.title
        }

    }
}


class ItemClickListener(val clickListener: (Item) -> Unit) {
    fun onClick(item: Item) = clickListener(item)
}

