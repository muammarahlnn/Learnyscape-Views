package com.muammarahlnn.lsv.data.notifications

import com.muammarahlnn.lsv.core.model.NotificationModel
import com.muammarahlnn.lsv.data.notifications.mapper.NotificationResponseToModel
import com.muammarahlnn.lsv.network.notifications.NotificationsNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsRepository, 20/04/2024 18.01
 */
class NotificationsRepository @Inject constructor(
    private val notificationsNetworkDataSource: NotificationsNetworkDataSource,
    private val notificationResponseToModel: NotificationResponseToModel,
) {

    fun getNotifications(): Flow<List<NotificationModel>> =
        notificationsNetworkDataSource.getNotifications().map {
            it.map(notificationResponseToModel::map)
        }
}