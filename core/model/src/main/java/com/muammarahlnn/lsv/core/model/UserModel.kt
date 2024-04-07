package com.muammarahlnn.lsv.core.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File UserModel, 05/04/2024 21.22
 */
data class UserModel(
    val id: String,
    val username: String,
    val fullName: String,
    val role: Role,
) {

    enum class Role {
        STUDENT, LECTURER
    }
}