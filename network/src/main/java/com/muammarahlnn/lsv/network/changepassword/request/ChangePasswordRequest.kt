package com.muammarahlnn.lsv.network.changepassword.request

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordRequest, 30/04/2024 16.20
 */
@Serializable
data class ChangePasswordRequest(
    val oldPassword: String,
    val newPassword: String,
)