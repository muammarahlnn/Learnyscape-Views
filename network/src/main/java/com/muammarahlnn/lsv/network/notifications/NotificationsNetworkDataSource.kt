package com.muammarahlnn.lsv.network.notifications

import com.muammarahlnn.lsv.network.notifications.response.NotificationResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsNetworkDataSource, 20/04/2024 17.59
 */
@Singleton
class NotificationsNetworkDataSource @Inject constructor(
    private val notificationsApi: NotificationsApi,
) {

    fun getNotifications(): Flow<List<NotificationResponse>> = flow {
        emit(notificationsApi.getNotifications().data)
    }
}