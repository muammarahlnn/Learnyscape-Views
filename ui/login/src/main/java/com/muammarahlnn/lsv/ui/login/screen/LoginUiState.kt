package com.muammarahlnn.lsv.ui.login.screen

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginUiState, 04/04/2024 00.13
 */
internal sealed interface LoginUiState  {

    data object None : LoginUiState

    data object Loading : LoginUiState

    data object OnSuccessLogin : LoginUiState

    data class OnErrorLogin(val message: String) : LoginUiState
}