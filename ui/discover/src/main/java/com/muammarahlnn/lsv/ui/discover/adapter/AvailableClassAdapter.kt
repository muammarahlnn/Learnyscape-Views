package com.muammarahlnn.lsv.ui.discover.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.model.AvailableClassModel
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.discover.databinding.ItemAvailableClassBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AvailableClassAdapter, 14/04/2024 14.11
 */
internal class AvailableClassAdapter(
    private val onItemClickListener: (AvailableClassModel) -> Unit,
) : BaseAdapter<AvailableClassModel, AvailableClassViewHolder>() {

    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): AvailableClassViewHolder {
        val viewBinding = ItemAvailableClassBinding.inflate(inflater, parent, false)
        return AvailableClassViewHolder(viewBinding, onItemClickListener)
    }
}