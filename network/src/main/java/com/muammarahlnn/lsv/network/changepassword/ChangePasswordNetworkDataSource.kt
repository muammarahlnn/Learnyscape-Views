package com.muammarahlnn.lsv.network.changepassword

import com.muammarahlnn.lsv.network.changepassword.request.ChangePasswordRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordNetworkDataSource, 30/04/2024 16.21
 */
@Singleton
class ChangePasswordNetworkDataSource @Inject constructor(
    private val changePasswordApi: ChangePasswordApi,
) {

    fun putChangePassword(
        oldPassword: String,
        newPassword: String,
    ): Flow<String> = flow {
        emit(
            changePasswordApi.putChangePassword(
                changePasswordRequest = ChangePasswordRequest(
                    oldPassword = oldPassword,
                    newPassword = newPassword,
                )
            ).data
        )
    }
}