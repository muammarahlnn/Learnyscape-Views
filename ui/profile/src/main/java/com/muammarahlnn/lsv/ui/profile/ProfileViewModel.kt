package com.muammarahlnn.lsv.ui.profile

import androidx.lifecycle.SavedStateHandle
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileViewModel, 19/03/2024 02.38
 */
@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    initialState: ProfileState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<ProfileState>(initialState, savedStateHandle)