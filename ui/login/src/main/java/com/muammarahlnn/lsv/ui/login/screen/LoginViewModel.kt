package com.muammarahlnn.lsv.ui.login.screen

import androidx.lifecycle.SavedStateHandle
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginViewModel, 11/03/2024 21.24
 */
@HiltViewModel
internal class LoginViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    initialState: LoginState,
) : BaseViewModel<LoginState>(initialState, savedStateHandle) {

}