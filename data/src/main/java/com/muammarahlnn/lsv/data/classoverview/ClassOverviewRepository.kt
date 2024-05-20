package com.muammarahlnn.lsv.data.classoverview

import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel
import com.muammarahlnn.lsv.data.classoverview.mapper.QuizOverviewResponseToModel
import com.muammarahlnn.lsv.data.classoverview.mapper.ReferenceOverviewResponseToModel
import com.muammarahlnn.lsv.data.classoverview.mapper.TaskOverviewResponseToModel
import com.muammarahlnn.lsv.network.classoverview.ClassOverviewNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewRepository, 20/05/2024 00.01
 */
class ClassOverviewRepository @Inject constructor(
    private val classOverviewNetworkDataSource: ClassOverviewNetworkDataSource,
    private val referenceOverviewResponseMapper: ReferenceOverviewResponseToModel,
    private val taskOverviewResponseMapper: TaskOverviewResponseToModel,
    private val quizOverviewResponseMapper: QuizOverviewResponseToModel,
) {

    fun getModules(classId: String): Flow<List<ClassResourceOverviewModel>> =
        classOverviewNetworkDataSource.getReferences(classId).map {
            it.map(referenceOverviewResponseMapper::map)
        }

    fun getAssignments(classId: String): Flow<List<ClassResourceOverviewModel>> =
        classOverviewNetworkDataSource.getTasks(classId).map {
            it.map(taskOverviewResponseMapper::map)
        }

    fun getQuizzes(classId: String): Flow<List<ClassResourceOverviewModel>> =
        classOverviewNetworkDataSource.getQuizzes(classId).map {
            it.map(quizOverviewResponseMapper::map)
        }
}