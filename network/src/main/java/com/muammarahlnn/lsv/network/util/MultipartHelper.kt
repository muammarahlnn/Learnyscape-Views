package com.muammarahlnn.lsv.network.util

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File MultipartHelper, 08/05/2024 22.01
 */
fun File.toImageRequestBody(): RequestBody =
    this.asRequestBody("image/*".toMediaTypeOrNull())