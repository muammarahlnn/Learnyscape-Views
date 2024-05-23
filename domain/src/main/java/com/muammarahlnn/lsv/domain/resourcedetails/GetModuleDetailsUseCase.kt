package com.muammarahlnn.lsv.domain.resourcedetails

import com.muammarahlnn.lsv.core.model.ModuleDetailsModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.resourcedetails.ResourceDetailsRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetModuleDetails, 23/05/2024 14.53
 */
class GetModuleDetailsUseCase @Inject constructor(
    private val resourceDetailsRepository: ResourceDetailsRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetModuleDetailsUseCase.Params, ModuleDetailsModel>(dispatcher) {

    override fun buildUseCase(params: Params): Flow<ModuleDetailsModel> =
        resourceDetailsRepository.getModuleDetails(params.moduleId)

    class Params(
        internal val moduleId: String,
    )

}