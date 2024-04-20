package com.muammarahlnn.lsv.domain.pendingrequest

import com.muammarahlnn.lsv.core.model.PendingRequestModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.pendingrequest.PendingRequestRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetStudentPendingRequestsUseCase, 21/04/2024 03.55
 */
class GetStudentPendingRequestsUseCase @Inject constructor(
    private val pendingRequestRepository: PendingRequestRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, List<PendingRequestModel>>(dispatcher) {

    override fun buildUseCase(params: Unit): Flow<List<PendingRequestModel>> =
        pendingRequestRepository.getStudentPendingRequests()
}