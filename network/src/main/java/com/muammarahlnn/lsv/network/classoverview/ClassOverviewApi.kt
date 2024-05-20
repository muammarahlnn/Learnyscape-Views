package com.muammarahlnn.lsv.network.classoverview

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.classoverview.response.QuizOverviewResponse
import com.muammarahlnn.lsv.network.classoverview.response.ReferenceOverviewResponse
import com.muammarahlnn.lsv.network.classoverview.response.TaskOverviewResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewApi, 19/05/2024 23.34
 */
interface ClassOverviewApi {

    @GET("references/classes/{classId}")
    suspend fun getReferences(
        @Path("classId") classId: String,
    ): BaseResponse<List<ReferenceOverviewResponse>>

    @GET("tasks/classes/{classId}")
    suspend fun getTasks(
        @Path("classId") classId: String,
    ): BaseResponse<List<TaskOverviewResponse>>

    @GET("quizzes/classes/{classId}")
    suspend fun getQuizzes(
        @Path("classId") classId: String,
    ): BaseResponse<List<QuizOverviewResponse>>
}