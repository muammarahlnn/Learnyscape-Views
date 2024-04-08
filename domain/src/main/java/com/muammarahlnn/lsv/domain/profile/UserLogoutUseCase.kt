package com.muammarahlnn.lsv.domain.profile

import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.profile.ProfileRepository
import com.muammarahlnn.lsv.domain.base.BaseSuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File UserLogoutUseCase, 08/04/2024 06.44
 */
class UserLogoutUseCase @Inject constructor(
    @Dispatcher(IO) private val dispatcher: CoroutineDispatcher,
    private val profileRepository: ProfileRepository,
) : BaseSuspendUseCase<Unit>() {

    override suspend fun buildUseCase(params: Unit) {
        withContext(dispatcher) {
            profileRepository.userLogout()
        }
    }
}