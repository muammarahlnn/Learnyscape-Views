package com.muammarahlnn.lsv.network.changepassword

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.changepassword.request.ChangePasswordRequest
import retrofit2.http.Body
import retrofit2.http.PUT

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordApi, 30/04/2024 16.19
 */
interface ChangePasswordApi {

    @PUT("users")
    suspend fun putChangePassword(
        @Body changePasswordRequest: ChangePasswordRequest,
    ): BaseResponse<String>
}