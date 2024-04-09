package com.muammarahlnn.lsv.network.home.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File EnrolledClassResponse, 09/04/2024 03.29
 */
@Serializable
data class EnrolledClassResponse(
    val id: String,
    val className: String,
    val lecturerNames: List<String>,
)