package com.muammarahlnn.lsv.network.profile.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChnagePhotoProfileResponse, 08/05/2024 21.59
 */
@Serializable
data class ChangePhotoProfileResponse(
    val name: String,
    val path: String,
)