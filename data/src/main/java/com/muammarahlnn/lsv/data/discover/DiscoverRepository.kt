package com.muammarahlnn.lsv.data.discover

import com.muammarahlnn.lsv.core.model.AvailableClassModel
import com.muammarahlnn.lsv.data.discover.mapper.AvailableClassResponseToModel
import com.muammarahlnn.lsv.network.discover.DiscoverNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverRepository, 14/04/2024 13.31
 */
class DiscoverRepository @Inject constructor(
    private val discoverNetworkDataSource: DiscoverNetworkDataSource,
    private val availableClassResponseToModel: AvailableClassResponseToModel,
) {

    fun getAvailableClasses(searchQuery: String): Flow<List<AvailableClassModel>> =
        discoverNetworkDataSource.getAvailableClasses(searchQuery).map {
            it.map(availableClassResponseToModel::map)
        }
}