package com.muammarahlnn.lsv.core.ui.widget.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseAdapter, 23/03/2024 14.36
 */
abstract class BaseAdapter<T : Any, VH : BaseViewHolder<*, T>> : Adapter<VH>() {

    private val items = mutableListOf<T>()

    fun setItems(items: List<T>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyItemRangeChanged(0, this.items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        return createViewHolder(inflater, parent)
    }

    abstract fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.render(items[position])
    }

    override fun getItemCount(): Int = items.size
}