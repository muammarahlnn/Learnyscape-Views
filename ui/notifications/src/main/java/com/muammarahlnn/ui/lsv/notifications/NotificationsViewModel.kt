package com.muammarahlnn.ui.lsv.notifications

import androidx.lifecycle.SavedStateHandle
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsViewModel, 20/04/2024 15.46
 */
@HiltViewModel
internal class NotificationsViewModel @Inject constructor(
    initialState: NotificationsUiState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<NotificationsUiState>(initialState, savedStateHandle)