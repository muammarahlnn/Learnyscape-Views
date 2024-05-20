package com.muammarahlnn.lsv.data.classmember.mapper

import com.muammarahlnn.lsv.core.model.ClassMembersModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.network.classmember.response.ClassMembersResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMembersResponseToModel, 20/05/2024 20.41
 */
class ClassMembersResponseToModel @Inject constructor() :
    Mapper<ClassMembersResponse, ClassMembersModel> {

    override fun map(from: ClassMembersResponse): ClassMembersModel = ClassMembersModel(
        lecturers = from.lecturers.map { lecturer ->
            ClassMembersModel.Member(
                id = lecturer.lecturerId,
                name = lecturer.name,
                profilePicUrl = lecturer.profileUri,
            )
        },
        students = from.students.map { student ->
            ClassMembersModel.Member(
                id = student.studentId,
                name = student.name,
                profilePicUrl = student.profileUri,
            )
        },
    )
}