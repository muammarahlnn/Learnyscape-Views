package com.muammarahlnn.lsv.ui.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.base.execute
import com.muammarahlnn.lsv.domain.profile.GetCurrentUserUseCase
import com.muammarahlnn.lsv.domain.profile.UserLogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileViewModel, 19/03/2024 02.38
 */
@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    initialState: ProfileUiState,
    savedStateHandle: SavedStateHandle,
    private val userLogoutUseCase: UserLogoutUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
) : BaseViewModel<ProfileUiState>(initialState, savedStateHandle) {

    fun userLogout() {
        userLogoutUseCase.execute(viewModelScope)
    }

    fun getCurrentUser() {
        getCurrentUserUseCase.execute(
            params = Unit,
            coroutineScope = viewModelScope,
            onSuccess = { user ->
                updateState {
                    ProfileUiState.OnGetCurrentUser(user)
                }
            },
        )
    }
}