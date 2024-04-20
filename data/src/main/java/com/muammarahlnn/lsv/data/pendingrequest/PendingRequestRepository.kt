package com.muammarahlnn.lsv.data.pendingrequest

import com.muammarahlnn.lsv.core.model.PendingRequestModel
import com.muammarahlnn.lsv.data.pendingrequest.mapper.PendingRequestResponseToModel
import com.muammarahlnn.lsv.network.pendingrequest.PendingRequestNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestRepository, 21/04/2024 03.50
 */
class PendingRequestRepository @Inject constructor(
    private val pendingRequestNetworkDataSource: PendingRequestNetworkDataSource,
    private val pendingRequestResponseToModel: PendingRequestResponseToModel,
) {

    fun getStudentPendingRequests(): Flow<List<PendingRequestModel>> =
        pendingRequestNetworkDataSource.getStudentPendingRequests().map {
            it.map(pendingRequestResponseToModel::map)
        }
}