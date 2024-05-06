package com.muammarahlnn.lsv.ui.schedule

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.schedule.GetSchedulesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleViewModel, 19/03/2024 02.41
 */
@HiltViewModel
internal class ScheduleViewModel @Inject constructor(
    private val getSchedulesUseCase: GetSchedulesUseCase,
    initialState: ScheduleUiState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<ScheduleUiState>(initialState, savedStateHandle) {

    fun fetchSchedules() {
        getSchedulesUseCase.execute(
            params = Unit,
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ScheduleUiState.Loading(true) }
            },
            onSuccess = { schedules ->
                updateState {
                    if (schedules.isNotEmpty()) ScheduleUiState.Success(schedules)
                    else ScheduleUiState.SuccessEmpty
                }
            },
            onError = { throwable ->
                updateState { ScheduleUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ScheduleUiState.Loading(false) }
            }
        )
    }
}