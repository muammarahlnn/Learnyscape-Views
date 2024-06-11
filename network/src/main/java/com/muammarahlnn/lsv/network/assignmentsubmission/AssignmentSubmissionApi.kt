package com.muammarahlnn.lsv.network.assignmentsubmission

import com.muammarahlnn.lsv.network.assignmentsubmission.response.StudentTaskSubmissionResponse
import com.muammarahlnn.lsv.network.base.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionApi, 10/06/2024 15.18
 */
interface AssignmentSubmissionApi {

    @GET("tasks/{taskId}/submissions")
    suspend fun studentGetTaskSubmission(
        @Path("taskId") taskId: String,
    ): BaseResponse<StudentTaskSubmissionResponse>
}