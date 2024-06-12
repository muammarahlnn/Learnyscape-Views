package com.muammarahlnn.lsv.ui.assignmentsubmission.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.assignmentsubmission.databinding.ItemSubmissionAttachmentBinding
import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File SubmissionAttachmentAdapter, 10/06/2024 16.57
 */
class SubmissionAttachmentAdapter(
    private val onItemClickListener: (File) -> Unit,
) : BaseAdapter<File, SubmissionAttachmentViewHolder>() {

    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): SubmissionAttachmentViewHolder {
        val viewBinding = ItemSubmissionAttachmentBinding.inflate(inflater, parent, false)
        return SubmissionAttachmentViewHolder(viewBinding, onItemClickListener)
    }
}