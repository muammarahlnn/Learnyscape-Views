package com.muammarahlnn.lsv.domain.classoverview

import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.classoverview.ClassOverviewRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetClassResourcesOverviewUseCase, 20/05/2024 01.04
 */
class GetClassResourceOverviewsUseCase @Inject constructor(
    private val classOverviewRepository: ClassOverviewRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetClassResourceOverviewsUseCase.Params, List<ClassResourceOverviewModel>>(dispatcher) {

    override fun buildUseCase(params: Params): Flow<List<ClassResourceOverviewModel>> =
        when (params.resourceType) {
            Params.ResourceType.MODULE -> classOverviewRepository.getModules(params.classId)
            Params.ResourceType.ASSIGNMENT -> classOverviewRepository.getAssignments(params.classId)
            Params.ResourceType.QUIZ -> classOverviewRepository.getQuizzes(params.classId)
        }

    class Params(
        internal val classId: String,
        internal val resourceType: ResourceType,
    ) {

        enum class ResourceType {
            MODULE, ASSIGNMENT, QUIZ,
        }
    }
}