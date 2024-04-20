package com.muammarahlnn.lsv.network.pendingrequest

import com.muammarahlnn.lsv.network.pendingrequest.response.PendingRequestResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestNetworkDataSource, 21/04/2024 03.47
 */
@Singleton
class PendingRequestNetworkDataSource @Inject constructor(
    private val pendingRequestApi: PendingRequestApi
) {

    fun getStudentPendingRequests(): Flow<List<PendingRequestResponse>> = flow {
        emit(pendingRequestApi.getStudentPendingRequests().data)
    }
}