package com.muammarahlnn.lsv.network.notifications.response

import com.muammarahlnn.lsv.network.classfeed.response.ClassResourceTypeResponse
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationResponse, 20/04/2024 17.56
 */
@Serializable
data class NotificationResponse(
    val id: String,
    val createdAt: String,
    val uri: String,
    val title: String,
    val description: String,
    val type: ClassResourceTypeResponse,
)