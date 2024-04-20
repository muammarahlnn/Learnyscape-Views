package com.muammarahlnn.lsv.network.pendingrequest

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.pendingrequest.response.PendingRequestResponse
import retrofit2.http.GET

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestApi, 21/04/2024 03.46
 */
interface PendingRequestApi {

    @GET("waiting-lists")
    suspend fun getStudentPendingRequests(): BaseResponse<List<PendingRequestResponse>>
}