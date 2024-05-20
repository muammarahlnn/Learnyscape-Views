package com.muammarahlnn.lsv.network.classoverview

import com.muammarahlnn.lsv.network.classoverview.response.QuizOverviewResponse
import com.muammarahlnn.lsv.network.classoverview.response.ReferenceOverviewResponse
import com.muammarahlnn.lsv.network.classoverview.response.TaskOverviewResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewNetworkDataSource, 19/05/2024 23.33
 */
@Singleton
class ClassOverviewNetworkDataSource @Inject constructor(
    private val classOverviewApi: ClassOverviewApi,
) {

    fun getReferences(classId: String): Flow<List<ReferenceOverviewResponse>> = flow {
        emit(classOverviewApi.getReferences(classId).data)
    }

    fun getTasks(classId: String): Flow<List<TaskOverviewResponse>> = flow {
        emit(classOverviewApi.getTasks(classId).data)
    }

    fun getQuizzes(classId: String): Flow<List<QuizOverviewResponse>> = flow {
        emit(classOverviewApi.getQuizzes(classId).data)
    }
}