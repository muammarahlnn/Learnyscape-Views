package com.muammarahlnn.lsv.domain.changepassword

import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.changepassword.ChangePasswordRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordUseCase, 30/04/2024 16.25
 */
class ChangePasswordUseCase @Inject constructor(
    private val changePasswordRepository: ChangePasswordRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<ChangePasswordUseCase.Params, String>(dispatcher) {

    override fun buildUseCase(params: ChangePasswordUseCase.Params): Flow<String> =
        changePasswordRepository.changePassword(
            oldPassword = params.oldPassword,
            newPassword = params.newPassword,
        )

    class Params(
        internal val oldPassword: String,
        internal val newPassword: String,
    )
}