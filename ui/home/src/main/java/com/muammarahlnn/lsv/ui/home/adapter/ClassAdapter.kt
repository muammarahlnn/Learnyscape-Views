package com.muammarahlnn.lsv.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.home.databinding.ItemClassBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassAdapter, 24/03/2024 03.42
 */
internal class ClassAdapter(
    private val onItemClickListener: (String) -> Unit,
) : BaseAdapter<String, ClassViewHolder>() {

    private val data = mutableListOf<String>()

    fun setData(data: List<String>) {
        this.data.apply {
            clear()
            addAll(data)
        }
        notifyItemRangeChanged(0, this.data.size)
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): ClassViewHolder {
        val viewBinding = ItemClassBinding.inflate(inflater, parent, false)
        return ClassViewHolder(viewBinding, onItemClickListener)
    }

    override fun bindViewHolder(holder: ClassViewHolder) {
        val state = data[holder.adapterPosition]
        holder.render(state)
    }

    override fun getItemCount(): Int = data.size
}