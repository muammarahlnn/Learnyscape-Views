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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        return createViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        bindViewHolder(holder)
    }

    abstract fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

    abstract fun bindViewHolder(holder: VH)
}