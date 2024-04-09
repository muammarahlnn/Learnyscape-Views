package com.muammarahlnn.lsv.data.home

import com.muammarahlnn.lsv.core.model.EnrolledClassModel
import com.muammarahlnn.lsv.data.home.mapper.EnrolledClassResponseToModel
import com.muammarahlnn.lsv.network.home.HomeNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeRepository, 09/04/2024 03.49
 */
class HomeRepository @Inject constructor(
    private val homeNetworkDataSource: HomeNetworkDataSource,
    private val enrolledClassResponseToModel: EnrolledClassResponseToModel,
) {

    fun getEnrolledClasses(): Flow<List<EnrolledClassModel>> =
        homeNetworkDataSource.getEnrolledClasses().map { it.map(enrolledClassResponseToModel::map) }
}