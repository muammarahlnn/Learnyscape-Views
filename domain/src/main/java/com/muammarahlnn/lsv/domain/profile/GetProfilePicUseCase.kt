package com.muammarahlnn.lsv.domain.profile

import android.graphics.Bitmap
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.profile.ProfileRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetProfilePic, 29/04/2024 03.16
 */
class GetProfilePicUseCase @Inject constructor(
    private val profileRepository: ProfileRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, Bitmap?>(dispatcher) {

    override fun buildUseCase(params: Unit): Flow<Bitmap?> =
        profileRepository.getProfilePic()
}