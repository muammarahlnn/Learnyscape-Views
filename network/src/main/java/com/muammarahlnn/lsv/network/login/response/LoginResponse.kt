package com.muammarahlnn.lsv.network.login.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginResponse, 30/03/2024 14.43
 */
@Serializable
data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
)