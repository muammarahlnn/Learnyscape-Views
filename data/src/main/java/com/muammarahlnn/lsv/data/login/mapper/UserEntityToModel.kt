package com.muammarahlnn.lsv.data.login.mapper

import com.muammarahlnn.lsv.core.model.UserModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.datastore.model.UserEntity
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File UserEntityToModel, 06/04/2024 15.20
 */
class UserEntityToModel @Inject constructor() : Mapper<UserEntity, UserModel> {

    override fun map(from: UserEntity): UserModel = UserModel(
        id = from.id,
        username = from.username,
        fullName = from.fullName,
        role = when (from.role) {
            UserModel.Role.STUDENT.name -> UserModel.Role.STUDENT
            UserModel.Role.LECTURER.name -> UserModel.Role.LECTURER
            else -> throw IllegalArgumentException("Role not found")
        }
    )
}