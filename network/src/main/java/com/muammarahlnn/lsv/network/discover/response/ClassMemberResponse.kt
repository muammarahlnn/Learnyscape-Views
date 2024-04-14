package com.muammarahlnn.lsv.network.discover.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberResponse, 13/04/2024 13.25
 */
@Serializable
data class ClassMemberResponse(
    val id: String,
    @SerialName("fullname") val fullName: String,
    val username: String,
)