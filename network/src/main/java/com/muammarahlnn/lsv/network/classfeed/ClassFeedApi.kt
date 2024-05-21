package com.muammarahlnn.lsv.network.classfeed

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.classfeed.response.ClassDetailsResponse
import com.muammarahlnn.lsv.network.classfeed.response.ClassFeedResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedApi, 21/05/2024 04.02
 */
interface ClassFeedApi {

    @GET("classes/{classId}")
    suspend fun getClassDetails(
        @Path("classId") classId: String,
    ): BaseResponse<ClassDetailsResponse>

    @GET("classes/{classId}/histories")
    suspend fun getClassFeeds(
        @Path("classId") classId: String,
    ): BaseResponse<List<ClassFeedResponse>>
}