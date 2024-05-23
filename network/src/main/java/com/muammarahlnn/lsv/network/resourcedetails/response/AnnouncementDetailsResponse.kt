package com.muammarahlnn.lsv.network.resourcedetails.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AnnouncementDetailsResponse, 23/05/2024 14.05
 */
@Serializable
data class AnnouncementDetailsResponse(
    val id: String,
    val authorName: String,
    val updatedAt: String,
    val description: String?,
    @SerialName("attachment") val attachmentUrls: List<String>,
)