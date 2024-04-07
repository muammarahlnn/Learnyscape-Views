package com.muammarahlnn.lsv.network.base

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseResponse, 30/03/2024 14.41
 */
@Serializable
class BaseResponse<T>(
    val status: String,
    val data: T,
)