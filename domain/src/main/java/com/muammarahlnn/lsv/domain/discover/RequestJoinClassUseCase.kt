package com.muammarahlnn.lsv.domain.discover

import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.discover.DiscoverRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File RequestJoinClassUseCase, 17/04/2024 20.31
 */
class RequestJoinClassUseCase @Inject constructor(
    private val discoverRepository: DiscoverRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<RequestJoinClassUseCase.Params, String>(dispatcher) {

    override fun buildUseCase(params: RequestJoinClassUseCase.Params): Flow<String> =
        discoverRepository.requestJoinClass(params.classId)

    class Params(
        internal val classId: String,
    )
}