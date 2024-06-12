package com.muammarahlnn.lsv.ui.assignmentsubmission.adapter

import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.assignmentsubmission.databinding.ItemSubmissionAttachmentBinding
import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File SubmissionAttachmentViewHolder, 10/06/2024 16.58
 */
class SubmissionAttachmentViewHolder(
    viewBinding: ItemSubmissionAttachmentBinding,
    private val onItemClickListener: (File) -> Unit,
) : BaseViewHolder<ItemSubmissionAttachmentBinding, File>(viewBinding) {

    override fun render(state: File) {
        with(viewBinding) {
            root.setOnClickListener {
                onItemClickListener(state)
            }

            tvName.text = state.name
        }
    }
}