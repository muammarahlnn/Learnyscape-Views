package com.muammarahlnn.lsv.network.classoverview.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File QuizOverviewResponse, 19/05/2024 23.36
 */
@Serializable
data class QuizOverviewResponse(
    val id: String,
    val name: String,
    val updatedAt: String,
    val startDate: Long,
)