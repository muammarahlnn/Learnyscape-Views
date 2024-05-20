package com.muammarahlnn.lsv.data.classmember

import com.muammarahlnn.lsv.core.model.ClassMembersModel
import com.muammarahlnn.lsv.data.classmember.mapper.ClassMembersResponseToModel
import com.muammarahlnn.lsv.network.classmember.ClassMemberNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberRepository, 20/05/2024 20.39
 */
class ClassMemberRepository @Inject constructor(
    private val classMemberNetworkDataSource: ClassMemberNetworkDataSource,
    private val classMembersResponseMapper: ClassMembersResponseToModel,
) {

    fun getClassMembers(classId: String): Flow<ClassMembersModel> =
        classMemberNetworkDataSource.getClassMembers(classId).map(classMembersResponseMapper::map)
}