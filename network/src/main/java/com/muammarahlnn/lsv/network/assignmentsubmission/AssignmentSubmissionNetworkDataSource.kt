package com.muammarahlnn.lsv.network.assignmentsubmission

import com.muammarahlnn.lsv.network.assignmentsubmission.response.StudentTaskSubmissionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionNetworkDataSource, 10/06/2024 15.21
 */
@Singleton
class AssignmentSubmissionNetworkDataSource @Inject constructor(
    private val assignmentSubmissionApi: AssignmentSubmissionApi,
) {

    fun studentGetTaskSubmission(taskId: String): Flow<StudentTaskSubmissionResponse> = flow {
        emit(assignmentSubmissionApi.studentGetTaskSubmission(taskId).data)
    }
}