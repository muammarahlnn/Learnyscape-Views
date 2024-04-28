package com.muammarahlnn.lsv.ui.profile

import com.muammarahlnn.lsv.core.model.UserModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File Profilestate, 19/03/2024 02.38
 */
internal sealed interface ProfileUiState {

    data object None : ProfileUiState

    data class OnGetCurrentUser(val user: UserModel) : ProfileUiState
}