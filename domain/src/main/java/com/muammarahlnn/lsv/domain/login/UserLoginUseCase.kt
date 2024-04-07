package com.muammarahlnn.lsv.domain.login

import com.muammarahlnn.lsv.core.model.UserModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.login.LoginRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File UserLoginUseCase, 30/03/2024 21.12
 */
class UserLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<UserLoginUseCase.Params, UserModel>(dispatcher) {


    override fun buildUseCase(params: Params): Flow<UserModel> =
        loginRepository.userLogin(
            username = params.username,
            password = params.password,
        )

    class Params(
        internal val username: String,
        internal val password: String,
    )
}