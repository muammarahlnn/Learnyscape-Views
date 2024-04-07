package com.muammarahlnn.lsv.data.login.mapper

import com.muammarahlnn.lsv.core.model.LoginModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.network.login.response.LoginResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginMapper, 30/03/2024 20.11
 */
class LoginResponseToModel @Inject constructor() : Mapper<LoginResponse, LoginModel>{

    override fun map(from: LoginResponse): LoginModel = LoginModel(
        accessToken = from.accessToken,
        refreshToken = from.refreshToken,
    )
}