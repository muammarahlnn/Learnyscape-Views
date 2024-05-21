package com.muammarahlnn.lsv.ui.classfeed.adapter

import com.muammarahlnn.lsv.core.model.ClassFeedModel
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.ANNOUNCEMENT
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.ASSIGNMENT
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.MODULE
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.QUIZ
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.classfeed.databinding.ItemFeedResourceBinding
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedViewHolder, 21/05/2024 19.14
 */
internal class ResourceFeedViewHolder(
    viewBinding: ItemFeedResourceBinding,
    private val onItemClickListener: (ClassFeedModel) -> Unit,
) : BaseViewHolder<ItemFeedResourceBinding, ClassFeedModel>(viewBinding){

    override fun render(state: ClassFeedModel) {
        viewBinding.root.also { view ->
            view.setOnClickListener { onItemClickListener(state) }
        }

        viewBinding.ivResourceType.also { view ->
            view.setImageResource(
                when (state.type) {
                    MODULE -> uiR.drawable.ic_book
                    ASSIGNMENT -> uiR.drawable.ic_assignment
                    QUIZ -> uiR.drawable.ic_quiz
                    ANNOUNCEMENT -> throw IllegalArgumentException()
                }
            )
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