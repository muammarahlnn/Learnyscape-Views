package com.muammarahlnn.lsv.network.resourcedetails.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File QuizDetailsResponse, 23/05/2024 14.06
 */
@Serializable
data class QuizDetailsResponse(
    val id: String,
    val name: String,
    val updatedAt: String,
    val description: String?,
    val startDate: Long,
    val endDate: Long,
    val duration: Int,
    val type: QuizType,
) {

    enum class QuizType {
        MULTIPLE_CHOICE,
        PHOTO_ANSWER
    }
}