package com.muammarahlnn.lsv.network.home

import com.muammarahlnn.lsv.network.home.response.EnrolledClassResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNetworkDataSource, 09/04/2024 03.37
 */
@Singleton
class HomeNetworkDataSource @Inject constructor(
    private val homeApi: HomeApi,
) {

    fun getEnrolledClasses(): Flow<List<EnrolledClassResponse>> = flow {
        emit(homeApi.getEnrolledClasses().data)
    }
}