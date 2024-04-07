package com.muammarahlnn.lsv.data.login.mapper

import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.datastore.model.UserEntity
import com.muammarahlnn.lsv.network.login.response.UserResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File UserResponseToEntity, 05/04/2024 21.12
 */
class UserResponseToEntity @Inject constructor() : Mapper<UserResponse, UserEntity> {

    override fun map(from: UserResponse): UserEntity = UserEntity(
        id = from.id,
        username = from.username,
        fullName = from.fullName,
        role = from.role.name,
    )
}