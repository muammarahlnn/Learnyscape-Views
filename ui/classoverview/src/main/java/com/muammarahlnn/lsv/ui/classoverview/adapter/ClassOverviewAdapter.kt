package com.muammarahlnn.lsv.ui.classoverview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.classoverview.databinding.ItemClassOverviewBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewAdapter, 20/05/2024 01.33
 */
internal class ClassOverviewAdapter(
    private val classOverviewScreen: ClassOverviewScreen,
    private val onItemClickListener: (ClassResourceOverviewModel) -> Unit,
) : BaseAdapter<ClassResourceOverviewModel, ClassOverviewViewHolder>(){

    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ClassOverviewViewHolder {
        val viewBinding = ItemClassOverviewBinding.inflate(inflater, parent, false)
        return ClassOverviewViewHolder(viewBinding, classOverviewScreen, onItemClickListener)
    }
}