package com.muammarahlnn.lsv.ui.schedule

import com.muammarahlnn.lsv.core.model.ScheduleModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleState, 19/03/2024 02.41
 */
internal sealed interface ScheduleUiState {

    data class Loading(val isLoading: Boolean) : ScheduleUiState

    data class Success(val schedules: List<ScheduleModel>) : ScheduleUiState

    data object SuccessEmpty : ScheduleUiState

    data class Error(val message: String) : ScheduleUiState
}