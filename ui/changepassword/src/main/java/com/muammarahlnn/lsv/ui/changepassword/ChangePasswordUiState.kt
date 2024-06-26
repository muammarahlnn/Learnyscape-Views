package com.muammarahlnn.lsv.ui.changepassword

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordUiState, 29/04/2024 19.45
 */
internal sealed interface ChangePasswordUiState {

    data object None : ChangePasswordUiState

    data object OnConfirmNewPasswordNotSame : ChangePasswordUiState

    data object OnLoadingChangePassword : ChangePasswordUiState

    data object OnSuccessChangePassword : ChangePasswordUiState

    data class OnErrorChangePassword(val message: String) : ChangePasswordUiState

    data object OnCompletionChangePassword : ChangePasswordUiState
}