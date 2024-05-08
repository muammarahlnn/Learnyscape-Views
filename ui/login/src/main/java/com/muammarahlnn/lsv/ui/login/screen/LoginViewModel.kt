package com.muammarahlnn.lsv.ui.login.screen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.login.UserLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginViewModel, 11/03/2024 21.24
 */
@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val userLoginUseCase: UserLoginUseCase,
    initialState: LoginUiState,
) : BaseViewModel<LoginUiState>(initialState) {

    fun userLogin(
        username: String,
        password: String,
    ) {
        userLoginUseCase.execute(
            params = UserLoginUseCase.Params(
                username = username,
                password = password,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    LoginUiState.Loading
                }
            },
            onSuccess = { userModel ->
                Log.d("LoginVM", userModel.username)
                updateState {
                    LoginUiState.OnSuccessLogin
                }
            },
            onError = { throwable ->
                updateState {
                    LoginUiState.OnErrorLogin(throwable.message.toString())
                }
            }
        )
    }
}