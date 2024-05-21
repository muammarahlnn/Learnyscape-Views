package com.muammarahlnn.lsv.data.classfeed

import com.muammarahlnn.lsv.core.model.ClassDetailsModel
import com.muammarahlnn.lsv.core.model.ClassFeedModel
import com.muammarahlnn.lsv.data.classfeed.mapper.ClassDetailsResponseToModel
import com.muammarahlnn.lsv.data.classfeed.mapper.ClassFeedResponseToModel
import com.muammarahlnn.lsv.network.classfeed.ClassFeedNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedRepository, 21/05/2024 04.10
 */
class ClassFeedRepository @Inject constructor(
    private val classFeedNetworkDataSource: ClassFeedNetworkDataSource,
    private val classDetailsResponseMapper: ClassDetailsResponseToModel,
    private val classFeedResponseMapper: ClassFeedResponseToModel,
) {

    fun getClassDetails(classId: String): Flow<ClassDetailsModel> =
        classFeedNetworkDataSource.getClassDetails(classId).map(classDetailsResponseMapper::map)

    fun getClassFeeds(classId: String): Flow<List<ClassFeedModel>> =
        classFeedNetworkDataSource.getClassFeeds(classId).map {
            it.map(classFeedResponseMapper::map)
        }
}