package com.muammarahlnn.lsv.ui.resourcedetails.adapter

import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.resourcedetails.databinding.ItemAttachmentBinding
import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AttachmentViewHolder, 23/05/2024 16.12
 */
internal class AttachmentViewHolder(
    viewBinding: ItemAttachmentBinding,
    private val onItemClickListener: (File) -> Unit,
) : BaseViewHolder<ItemAttachmentBinding, File>(viewBinding) {

    override fun render(state: File) {
        viewBinding.root.also { view ->
            view.setOnClickListener { onItemClickListener(state) }
        }

        viewBinding.tvName.also { view ->
            view.text = state.name
        }
    }
}