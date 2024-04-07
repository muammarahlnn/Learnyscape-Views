package com.muammarahlnn.lsv.data.login

import com.muammarahlnn.lsv.core.model.UserModel
import com.muammarahlnn.lsv.data.login.mapper.LoginResponseToModel
import com.muammarahlnn.lsv.data.login.mapper.UserEntityToModel
import com.muammarahlnn.lsv.data.login.mapper.UserResponseToEntity
import com.muammarahlnn.lsv.datastore.LsvPreferencesDataSource
import com.muammarahlnn.lsv.network.login.LoginNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginRepository, 30/03/2024 19.28
 */
class LoginRepository @Inject constructor(
    private val loginNetworkDataSource: LoginNetworkDataSource,
    private val lsvPreferencesDataSource: LsvPreferencesDataSource,
    private val loginResponseToModel: LoginResponseToModel,
    private val userResponseToEntity: UserResponseToEntity,
    private val userEntityToModel: UserEntityToModel,
) {

    fun userLogin(
        username: String,
        password: String,
    ): Flow<UserModel> = loginNetworkDataSource.postLogin(
        username = username,
        password = password,
    ).flatMapLatest { loginResponse ->
        lsvPreferencesDataSource.saveAccessToken(loginResponse.accessToken)
        loginNetworkDataSource.getCredential(loginResponse.accessToken).map { userResponse ->
            userResponseToEntity.map(userResponse)
        }
    }.map { userEntity ->
        userEntityToModel.map(userEntity)
    }
}