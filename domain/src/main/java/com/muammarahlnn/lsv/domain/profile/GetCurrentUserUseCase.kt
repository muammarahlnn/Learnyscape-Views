package com.muammarahlnn.lsv.domain.profile

import com.muammarahlnn.lsv.core.model.UserModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.profile.ProfileRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetCurrentUserUseCase, 28/04/2024 14.19
 */
class GetCurrentUserUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, UserModel>(dispatcher) {

    override fun buildUseCase(params: Unit): Flow<UserModel> =
        profileRepository.getCurrentUser()
}