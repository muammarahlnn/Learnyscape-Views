package com.muammarahlnn.lsv.data.changepassword

import com.muammarahlnn.lsv.network.changepassword.ChangePasswordNetworkDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordRepository, 30/04/2024 16.24
 */
class ChangePasswordRepository @Inject constructor(
    private val changePasswordNetworkDataSource: ChangePasswordNetworkDataSource,
) {

    fun changePassword(
        oldPassword: String,
        newPassword: String,
    ): Flow<String> = changePasswordNetworkDataSource.putChangePassword(oldPassword, newPassword)
}