package com.muammarahlnn.lsv.ui.pendingrequest

import androidx.lifecycle.SavedStateHandle
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestViewModel, 21/04/2024 03.02
 */
@HiltViewModel
internal class PendingRequestViewModel @Inject constructor(
    initialState: PendingRequestUiState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<PendingRequestUiState>(initialState, savedStateHandle)