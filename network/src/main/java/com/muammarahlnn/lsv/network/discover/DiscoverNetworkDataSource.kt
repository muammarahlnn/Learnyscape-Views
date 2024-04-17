package com.muammarahlnn.lsv.network.discover

import com.muammarahlnn.lsv.network.discover.request.RequestJoinClassRequest
import com.muammarahlnn.lsv.network.discover.response.AvailableClassResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverNetworkDataSource, 13/04/2024 13.21
 */
@Singleton
class DiscoverNetworkDataSource @Inject constructor(
    private val discoverApi: DiscoverApi,
) {

    fun getAvailableClasses(searchQuery: String): Flow<List<AvailableClassResponse>> = flow {
        emit(discoverApi.getAvailableClasses(searchQuery).data)
    }

    fun requestJoinClass(classId: String): Flow<String> = flow {
        emit(
            discoverApi.putRequestJoinClass(
                RequestJoinClassRequest(classId)
            ).data
        )
    }

    fun cancelRequestJoinClass(classId: String): Flow<String> = flow {
        emit(
            discoverApi.putRequestJoinClass(
                RequestJoinClassRequest(
                    classId = classId,
                    isCancelled = true,
                )
            ).data
        )
    }
}