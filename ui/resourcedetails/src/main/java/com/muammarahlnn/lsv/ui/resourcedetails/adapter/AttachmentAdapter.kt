package com.muammarahlnn.lsv.ui.resourcedetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.resourcedetails.databinding.ItemAttachmentBinding
import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AttachmentAdapter, 23/05/2024 16.11
 */
internal class AttachmentAdapter(
    private val onItemClickListener: (File) -> Unit,
) : BaseAdapter<File, AttachmentViewHolder>() {

    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): AttachmentViewHolder {
        val viewBinding = ItemAttachmentBinding.inflate(inflater, parent, false)
        return AttachmentViewHolder(viewBinding, onItemClickListener)
    }
}