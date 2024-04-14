package com.muammarahlnn.lsv.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.model.EnrolledClassModel
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.home.databinding.ItemClassBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassAdapter, 24/03/2024 03.42
 */
internal class ClassAdapter(
    private val onItemClickListener: (EnrolledClassModel) -> Unit,
) : BaseAdapter<EnrolledClassModel, ClassViewHolder>() {

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): ClassViewHolder {
        val viewBinding = ItemClassBinding.inflate(inflater, parent, false)
        return ClassViewHolder(viewBinding, onItemClickListener)
    }
}