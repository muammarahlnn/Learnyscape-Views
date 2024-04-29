package com.muammarahlnn.lsv.ui.changepassword

import androidx.lifecycle.SavedStateHandle
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordViewModel, 29/04/2024 19.46
 */
@HiltViewModel
internal class ChangePasswordViewModel @Inject constructor(
    initialState: ChangePasswordUiState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<ChangePasswordUiState>(initialState, savedStateHandle)