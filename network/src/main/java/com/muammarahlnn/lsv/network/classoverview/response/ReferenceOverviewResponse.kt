package com.muammarahlnn.lsv.network.classoverview.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ReferenceOverviewResponse, 19/05/2024 23.35
 */
@Serializable
data class ReferenceOverviewResponse(
    val id: String,
    val name: String,
    val updatedAt: String,
)