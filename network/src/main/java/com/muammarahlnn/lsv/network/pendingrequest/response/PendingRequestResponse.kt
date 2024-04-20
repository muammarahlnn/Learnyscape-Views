package com.muammarahlnn.lsv.network.pendingrequest.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestResponse, 21/04/2024 03.46
 */
@Serializable
data class PendingRequestResponse(
    val id: String,
    val classId: String,
    val className: String,
    val lecturers: List<String>,
)