package com.muammarahlnn.lsv.core.ui.widget.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseViewHolder, 23/03/2024 14.38
 */
abstract class BaseViewHolder<VB : ViewBinding, T : Any>(
    protected val viewBinding: VB,
) : ViewHolder(viewBinding.root) {

    val context: Context
        get() = viewBinding.root.context

    abstract fun render(state: T)
}