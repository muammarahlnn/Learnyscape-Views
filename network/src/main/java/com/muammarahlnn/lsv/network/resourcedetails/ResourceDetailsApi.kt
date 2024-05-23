package com.muammarahlnn.lsv.network.resourcedetails

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.resourcedetails.response.AnnouncementDetailsResponse
import com.muammarahlnn.lsv.network.resourcedetails.response.QuizDetailsResponse
import com.muammarahlnn.lsv.network.resourcedetails.response.ReferenceDetailsResponse
import com.muammarahlnn.lsv.network.resourcedetails.response.TaskDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsApi, 23/05/2024 14.01
 */
interface ResourceDetailsApi {

    @GET("announcements/{announcementId}")
    suspend fun getAnnouncementDetails(
        @Path("announcementId") announcementId: String,
    ): BaseResponse<AnnouncementDetailsResponse>

    @GET("references/{referenceId}")
    suspend fun getReferenceDetails(
        @Path("referenceId") referenceId: String,
    ): BaseResponse<ReferenceDetailsResponse>

    @GET("tasks/{taskId}")
    suspend fun getTaskDetails(
        @Path("taskId") taskId: String,
    ): BaseResponse<TaskDetailsResponse>

    @GET("quizzes/{quizId}")
    suspend fun getQuizDetails(
        @Path("quizId") quizId: String,
    ): BaseResponse<QuizDetailsResponse>
}