package com.muammarahlnn.lsv.domain.profile

import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.profile.ProfileRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import java.io.File
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePhotoProfileUseCase, 08/05/2024 22.07
 */
class ChangeProfilePicUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<ChangeProfilePicUseCase.Params, String>(dispatcher) {
    override fun buildUseCase(params: Params): Flow<String> =
        profileRepository.changeProfilePic(params.pic)

    class Params(
        internal val pic: File
    )
}