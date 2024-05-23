package com.muammarahlnn.lsv.network.attachment

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AttachmentApi, 23/05/2024 14.17
 */
interface AttachmentApi {

    @GET
    suspend fun getAttachment(
        @Url attachmentUrl: String,
    ): Response<ResponseBody>
}