package com.muammarahlnn.lsv.network.classfeed.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassResourceTypeResponse, 20/04/2024 17.58
 */
@Serializable
data class ClassFeedResponse(
    val id: String,
    val name: String? = null,
    val description: String? = null,
    val createdAt: String,
    val type: ClassResourceTypeResponse,
    val uri: String,
    @SerialName("thumbnail") val profilePicUrl: String? = null,
)

enum class ClassResourceTypeResponse {
    ANNOUNCEMENT,
    REFERENCE,
    TASK,
    QUIZ,
}