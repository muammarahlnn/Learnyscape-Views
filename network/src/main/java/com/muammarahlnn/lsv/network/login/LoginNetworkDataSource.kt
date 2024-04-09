package com.muammarahlnn.lsv.network.login

import com.muammarahlnn.lsv.network.login.response.LoginResponse
import com.muammarahlnn.lsv.network.login.response.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Credentials
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginNetworkDataSource, 30/03/2024 15.09
 */
@Singleton
class LoginNetworkDataSource @Inject constructor(
    private val loginApi: LoginApi,
) {

    fun postLogin(
        username: String,
        password: String,
    ): Flow<LoginResponse> = flow {
        val basicAuth = Credentials.basic(username, password)
        emit(loginApi.postLogin(basicAuth).data)
    }

    fun getCredential(token: String): Flow<UserResponse> = flow {
        val bearerToken = "Bearer $token"
        emit(loginApi.getCredential(bearerToken).data)
    }
}