package com.muammarahlnn.lsv.network.api

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.login.response.LoginResponse
import com.muammarahlnn.lsv.network.login.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginApi, 30/03/2024 14.40
 */
interface LoginApi {

    @POST("users/login")
    suspend fun postLogin(
        @Header("Authorization") basicAuth: String,
    ): BaseResponse<LoginResponse>

    @GET("users")
    suspend fun getCredential(
        @Header("Authorization") bearerToken: String,
    ): BaseResponse<UserResponse>
}