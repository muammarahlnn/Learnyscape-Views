package com.muammarahlnn.lsv.network.home

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.home.response.EnrolledClassResponse
import retrofit2.http.GET

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeApi, 09/04/2024 03.26
 */
interface HomeApi {

    @GET("users/classes")
    suspend fun getEnrolledClasses(): BaseResponse<List<EnrolledClassResponse>>
}