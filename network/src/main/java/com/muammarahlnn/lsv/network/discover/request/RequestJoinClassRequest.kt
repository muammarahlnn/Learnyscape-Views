package com.muammarahlnn.lsv.network.discover.request

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File RequestJoinClassRequest, 17/04/2024 20.09
 */
@Serializable
data class RequestJoinClassRequest(
    val classId: String,
    val isCancelled: Boolean = false,
)