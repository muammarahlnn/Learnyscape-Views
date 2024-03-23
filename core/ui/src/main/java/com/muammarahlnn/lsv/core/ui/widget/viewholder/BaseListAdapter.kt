package com.muammarahlnn.lsv.core.ui.widget.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseListAdapter, 23/03/2024 15.11
 */
abstract class BaseListAdapter<T : Any, VH : BaseViewHolder<*, T>>(
    diffCallback: ItemCallback<T>
) : ListAdapter<T, VH>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        return createViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        holder.render(item)

        if (position < itemCount - 1) return
        onReachEndOfItems(item)
    }

    abstract fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

    abstract fun onReachEndOfItems(item: T)

    fun getItemAt(position: Int): T? =
        if (position < 0 || position >= itemCount) null else getItem(position)

    fun lastItem(): T? = getItemAt(itemCount - 1)

    fun clearData() {
        submitList(listOf())
    }
}