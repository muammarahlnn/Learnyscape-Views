package com.muammarahlnn.lsv.core.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMembersModel, 20/05/2024 20.40
 */
data class ClassMembersModel(
    val lecturers: List<Member>,
    val students: List<Member>,
) {

    data class Member(
        val id: String,
        val name: String,
        val profilePicUrl: String,
    )
}