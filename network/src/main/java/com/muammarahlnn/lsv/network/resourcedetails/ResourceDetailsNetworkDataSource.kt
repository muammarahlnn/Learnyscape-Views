package com.muammarahlnn.lsv.network.resourcedetails

import com.muammarahlnn.lsv.network.resourcedetails.response.AnnouncementDetailsResponse
import com.muammarahlnn.lsv.network.resourcedetails.response.QuizDetailsResponse
import com.muammarahlnn.lsv.network.resourcedetails.response.ReferenceDetailsResponse
import com.muammarahlnn.lsv.network.resourcedetails.response.TaskDetailsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsNetworkDataSource, 23/05/2024 14.11
 */
@Singleton
class ResourceDetailsNetworkDataSource @Inject constructor(
    private val resourceDetailsApi: ResourceDetailsApi,
) {

    fun getAnnouncementDetails(announcementId: String): Flow<AnnouncementDetailsResponse> = flow {
        emit(resourceDetailsApi.getAnnouncementDetails(announcementId).data)
    }

    fun getReferenceDetails(referenceId: String): Flow<ReferenceDetailsResponse> = flow {
        emit(resourceDetailsApi.getReferenceDetails(referenceId).data)
    }

    fun getTaskDetails(taskId: String): Flow<TaskDetailsResponse> = flow {
        emit(resourceDetailsApi.getTaskDetails(taskId).data)
    }

    fun getQuizDetails(quizId: String): Flow<QuizDetailsResponse> = flow {
        emit(resourceDetailsApi.getQuizDetails(quizId).data)
    }
}