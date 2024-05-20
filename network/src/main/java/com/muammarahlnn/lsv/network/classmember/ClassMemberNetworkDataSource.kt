package com.muammarahlnn.lsv.network.classmember

import com.muammarahlnn.lsv.network.classmember.response.ClassMembersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberNetworkDataSource, 20/05/2024 20.36
 */
@Singleton
class ClassMemberNetworkDataSource @Inject constructor(
    private val classMemberApi: ClassMemberApi,
) {

    fun getClassMembers(classId: String): Flow<ClassMembersResponse> = flow {
        emit(classMemberApi.getClassMembers(classId).data)
    }
}