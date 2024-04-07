package com.muammarahlnn.lsv.network.login.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File UserResponse, 30/03/2024 15.01
 */
@Serializable
data class UserResponse(
    @SerialName("userId") val id: String,
    val username: String,
    @SerialName("fullname") val fullName: String,
    val role: Role,
) {
    enum class Role {
        STUDENT, LECTURER
    }
}