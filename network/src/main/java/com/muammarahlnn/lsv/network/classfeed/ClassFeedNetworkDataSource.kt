package com.muammarahlnn.lsv.network.classfeed

import com.muammarahlnn.lsv.network.classfeed.response.ClassDetailsResponse
import com.muammarahlnn.lsv.network.classfeed.response.ClassFeedResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedNetworkDataSource, 21/05/2024 04.05
 */
@Singleton
class ClassFeedNetworkDataSource @Inject constructor(
    private val classFeedApi: ClassFeedApi,
) {

    fun getClassDetails(classId: String): Flow<ClassDetailsResponse> = flow {
        emit(classFeedApi.getClassDetails(classId).data)
    }

    fun getClassFeeds(classId: String): Flow<List<ClassFeedResponse>> = flow {
        emit(classFeedApi.getClassFeeds(classId).data)
    }
}