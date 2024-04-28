package com.muammarahlnn.lsv.network.profile

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileApi, 29/04/2024 03.00
 */
interface ProfileApi {

    @GET("users/pic")
    suspend fun getProfilePic(): Response<ResponseBody>
}