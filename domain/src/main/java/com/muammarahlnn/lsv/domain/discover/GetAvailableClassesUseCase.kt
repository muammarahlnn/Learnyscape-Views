package com.muammarahlnn.lsv.domain.discover

import com.muammarahlnn.lsv.core.model.AvailableClassModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.discover.DiscoverRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetAvailableClassesUseCase, 14/04/2024 13.58
 */
class GetAvailableClassesUseCase @Inject constructor(
    private val discoverRepository: DiscoverRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetAvailableClassesUseCase.Params, List<AvailableClassModel>>(dispatcher) {

    override fun buildUseCase(params: GetAvailableClassesUseCase.Params): Flow<List<AvailableClassModel>> =
        discoverRepository.getAvailableClasses(params.searchQuery)

    class Params(
        internal val searchQuery: String = "",
    )
}