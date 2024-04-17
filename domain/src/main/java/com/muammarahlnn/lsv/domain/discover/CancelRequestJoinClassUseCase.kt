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
 * @File CancelRequestJoinClassUseCase, 17/04/2024 21.28
 */
class CancelRequestJoinClassUseCase @Inject constructor(
    private val discoverRepository: DiscoverRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<CancelRequestJoinClassUseCase.Params, String>(dispatcher) {

    override fun buildUseCase(params: CancelRequestJoinClassUseCase.Params): Flow<String> =
        discoverRepository.cancelRequestJoinClass(params.classId)

    class Params(
        internal val classId: String,
    )
}