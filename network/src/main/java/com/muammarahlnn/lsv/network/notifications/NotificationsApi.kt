package com.muammarahlnn.lsv.network.notifications

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.notifications.response.NotificationResponse
import retrofit2.http.GET

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsApi, 20/04/2024 17.55
 */
interface NotificationsApi {

    @GET("notifications/classes")
    suspend fun getNotifications(): BaseResponse<List<NotificationResponse>>
}