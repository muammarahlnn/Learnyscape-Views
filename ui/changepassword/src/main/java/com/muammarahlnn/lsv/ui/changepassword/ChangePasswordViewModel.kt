package com.muammarahlnn.lsv.ui.changepassword

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.changepassword.ChangePasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordViewModel, 29/04/2024 19.46
 */
@HiltViewModel
internal class ChangePasswordViewModel @Inject constructor(
    private val changePasswordUseCase: ChangePasswordUseCase,
    initialState: ChangePasswordUiState,
) : BaseViewModel<ChangePasswordUiState>(initialState) {

    fun changePassword(
        oldPassword: String,
        newPassword: String,
        confirmNewPassword: String,
    ) {
        if (newPassword != confirmNewPassword) {
            updateState { ChangePasswordUiState.OnConfirmNewPasswordNotSame }
            updateState { ChangePasswordUiState.OnCompletionChangePassword }
            return
        }

        changePasswordUseCase.execute(
            params = ChangePasswordUseCase.Params(
                oldPassword = oldPassword,
                newPassword = newPassword,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ChangePasswordUiState.OnLoadingChangePassword }
            },
            onSuccess = {
                updateState { ChangePasswordUiState.OnSuccessChangePassword }
            },
            onError = { throwable ->
                updateState {
                    ChangePasswordUiState.OnErrorChangePassword(throwable.message.toString())
                }
            },
            onCompletion = {
                updateState { ChangePasswordUiState.OnCompletionChangePassword }
            }
        )
    }
}