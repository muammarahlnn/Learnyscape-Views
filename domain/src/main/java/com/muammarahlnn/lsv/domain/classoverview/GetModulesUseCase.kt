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
 * @File GetModulesUseCase, 20/05/2024 00.15
 */
class GetModulesUseCase @Inject constructor(
    private val classOverviewRepository: ClassOverviewRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetModulesUseCase.Params, List<ClassResourceOverviewModel>>(dispatcher) {

    override fun buildUseCase(params: Params): Flow<List<ClassResourceOverviewModel>> =
        classOverviewRepository.getModules(params.classId)

    class Params(
        internal val classId: String,
    )
}