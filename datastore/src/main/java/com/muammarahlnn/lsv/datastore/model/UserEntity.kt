package com.muammarahlnn.lsv.datastore.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File UserEntity, 30/03/2024 19.23
 */
data class UserEntity(
    val id: String,
    val username: String,
    val fullName: String,
    val role: String,
)