package com.muammarahlnn.lsv.core.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File QuizDetailsModel, 23/05/2024 14.16
 */
data class QuizDetailsModel(
    val id: String,
    val name: String,
    val updatedAt: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val duration: Int,
    val quizType: QuizType,
) {

    enum class QuizType {
        MULTIPLE_CHOICE,
        PHOTO_ANSWER,
    }
}