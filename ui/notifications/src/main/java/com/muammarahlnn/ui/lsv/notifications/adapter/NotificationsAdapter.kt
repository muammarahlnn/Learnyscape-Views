package com.muammarahlnn.ui.lsv.notifications.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.model.NotificationModel
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.notifications.databinding.ItemNotificationBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsAdapter, 20/04/2024 18.21
 */
internal class NotificationsAdapter(
    private val onItemClickListener: (NotificationModel) -> Unit,
) : BaseAdapter<NotificationModel, NotificationsViewHolder>() {

    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): NotificationsViewHolder {
        val viewBinding = ItemNotificationBinding.inflate(inflater, parent, false)
        return NotificationsViewHolder(viewBinding, onItemClickListener)
    }
}