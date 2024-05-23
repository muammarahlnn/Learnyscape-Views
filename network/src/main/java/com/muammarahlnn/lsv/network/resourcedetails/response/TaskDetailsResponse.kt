package com.muammarahlnn.lsv.network.resourcedetails.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File TaskDetailsResponse, 23/05/2024 14.06
 */
@Serializable
data class TaskDetailsResponse(
    val id: String,
    val name: String,
    val updatedAt: String,
    val dueDate: Long,
    val description: String?,
    @SerialName("attachment") val attachmentUrls: List<String>,
)