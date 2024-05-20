package com.muammarahlnn.lsv.network.classmember.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberResponse, 20/05/2024 20.25
 */
@Serializable
data class ClassMembersResponse(
    val classId: String,
    val className: String,
    val lecturers: List<LecturerMemberResponse>,
    val students: List<StudentMemberResponse>,
)