package com.muammarahlnn.lsv.ui.profile

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.base.execute
import com.muammarahlnn.lsv.domain.profile.ChangeProfilePicUseCase
import com.muammarahlnn.lsv.domain.profile.GetCurrentUserUseCase
import com.muammarahlnn.lsv.domain.profile.GetProfilePicUseCase
import com.muammarahlnn.lsv.domain.profile.UserLogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileViewModel, 19/03/2024 02.38
 */
@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    private val userLogoutUseCase: UserLogoutUseCase,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val getProfilePicUseCase: GetProfilePicUseCase,
    private val changeProfilePicUseCase: ChangeProfilePicUseCase,
    initialState: ProfileUiState,
) : BaseViewModel<ProfileUiState>(initialState) {

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

    fun fetchProfilePic() {
        getProfilePicUseCase.execute(
            params = Unit,
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    ProfileUiState.OnLoadingFetchProfilePic
                }
            },
            onSuccess = { profilePic ->
                updateState {
                    ProfileUiState.OnSuccessFetchProfilePic(profilePic)
                }
            }
        )
    }

    fun changeProfilePic(pic: File) {
        changeProfilePicUseCase.execute(
            params = ChangeProfilePicUseCase.Params(
                pic = pic,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    ProfileUiState.OnLoadingFetchProfilePic
                }
            },
            onCompletion = {
                fetchProfilePic()
            },
        )
    }
}