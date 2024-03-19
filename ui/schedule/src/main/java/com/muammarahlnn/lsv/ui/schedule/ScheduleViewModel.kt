package com.muammarahlnn.lsv.ui.schedule

import androidx.lifecycle.SavedStateHandle
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleViewModel, 19/03/2024 02.41
 */
@HiltViewModel
internal class ScheduleViewModel @Inject constructor(
    initialState: ScheduleState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<ScheduleState>(initialState, savedStateHandle)