package com.muammarahlnn.lsv.network.classoverview.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File TaskOverviewResponse, 19/05/2024 23.36
 */
@Serializable
data class TaskOverviewResponse(
    val id: String,
    val name: String,
    val updatedAt: String,
    val dueDate: Long,
)