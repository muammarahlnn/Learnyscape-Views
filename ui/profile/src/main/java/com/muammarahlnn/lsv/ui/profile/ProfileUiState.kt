package com.muammarahlnn.lsv.ui.profile

import android.graphics.Bitmap
import com.muammarahlnn.lsv.core.model.UserModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File Profilestate, 19/03/2024 02.38
 */
internal sealed interface ProfileUiState {

    data object None : ProfileUiState

    data class OnGetCurrentUser(val user: UserModel) : ProfileUiState

    data object OnLoadingFetchProfilePic : ProfileUiState

    data class OnSuccessFetchProfilePic(val profilePic: Bitmap?) : ProfileUiState
}