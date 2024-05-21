package com.muammarahlnn.lsv.ui.classfeed.adapter

import com.muammarahlnn.lsv.core.model.ClassFeedModel
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.classfeed.databinding.ItemFeedAnnouncementBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AnnouncementFeedViewHolder, 22/05/2024 01.29
 */
internal class AnnouncementFeedViewHolder(
    viewBinding: ItemFeedAnnouncementBinding,
    private val onItemClickListener: (ClassFeedModel) -> Unit,
) : BaseViewHolder<ItemFeedAnnouncementBinding, ClassFeedModel>(viewBinding) {

    override fun render(state: ClassFeedModel) {
        viewBinding.root.also { view ->
            view.setOnClickListener { onItemClickListener(state) }
        }

        viewBinding.tvName.also { view ->
            view.text = state.name
        }

        viewBinding.tvDate.also { view ->
            view.text = state.createdAt
        }

        viewBinding.tvDesc.also { view ->
            view.text = state.description
        }
    }
}