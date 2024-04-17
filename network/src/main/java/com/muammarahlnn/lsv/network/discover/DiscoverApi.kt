package com.muammarahlnn.lsv.network.discover

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.discover.request.RequestJoinClassRequest
import com.muammarahlnn.lsv.network.discover.response.AvailableClassResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverApi, 13/04/2024 13.21
 */
interface DiscoverApi {

    @GET("classes")
    suspend fun getAvailableClasses(
        @Query("search") searchQuery: String,
    ): BaseResponse<List<AvailableClassResponse>>

    @PUT("users/classes")
    suspend fun putRequestJoinClass(
        @Body requestJoinClassRequest: RequestJoinClassRequest,
    ): BaseResponse<String>
}