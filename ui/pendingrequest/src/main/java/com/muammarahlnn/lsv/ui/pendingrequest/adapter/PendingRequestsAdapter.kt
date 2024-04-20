package com.muammarahlnn.lsv.ui.pendingrequest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.model.PendingRequestModel
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.pendingrequest.databinding.ItemPendingRequestBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestsAdapter, 21/04/2024 04.05
 */
internal class PendingRequestsAdapter(
    private val onItemClickListener: (PendingRequestModel) -> Unit,
) : BaseAdapter<PendingRequestModel, PendingRequestViewHolder>() {

    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): PendingRequestViewHolder {
        val viewBinding = ItemPendingRequestBinding.inflate(inflater, parent, false)
        return PendingRequestViewHolder(viewBinding, onItemClickListener)
    }
}