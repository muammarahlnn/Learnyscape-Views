package com.muammarahlnn.ui.lsv.notifications.adapter

import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel
import com.muammarahlnn.lsv.core.model.NotificationModel
import com.muammarahlnn.lsv.core.ui.ext.readDrawable
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.notifications.databinding.ItemNotificationBinding
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsViewHolder, 20/04/2024 18.21
 */
internal class NotificationsViewHolder(
    viewBinding: ItemNotificationBinding,
    private val onItemClickListener: (NotificationModel) -> Unit,
) : BaseViewHolder<ItemNotificationBinding, NotificationModel>(viewBinding) {

    override fun render(state: NotificationModel) {
        viewBinding.root.also { view ->
            view.setOnClickListener {
                onItemClickListener(state)
            }
        }

        viewBinding.tvTitle.also { view ->
            view.text = state.title
        }

        viewBinding.tvDescription.also { view ->
            view.text = state.description
        }

        viewBinding.tvDate.also { view ->
            view.text = state.createdAt.substringBefore(',')
        }

        viewBinding.icResourceType.also { view ->
            val resourceTypeIconRes = when (state.type) {
                ClassResourceTypeModel.ANNOUNCEMENT -> uiR.drawable.ic_announcement_border
                ClassResourceTypeModel.MODULE -> uiR.drawable.ic_book_border
                ClassResourceTypeModel.ASSIGNMENT -> uiR.drawable.ic_assignment_border
                ClassResourceTypeModel.QUIZ -> uiR.drawable.ic_quiz_border
            }
            view.setImageDrawable(context.readDrawable(resourceTypeIconRes))
        }
    }
}