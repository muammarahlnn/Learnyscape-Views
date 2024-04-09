package com.muammarahlnn.lsv.ui.home

import com.muammarahlnn.lsv.core.model.EnrolledClassModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeState, 19/03/2024 02.35
 */
internal sealed interface HomeUiState {

    data object Loading : HomeUiState

    data class Success(val enrolledClasses: List<EnrolledClassModel>) : HomeUiState

    data object SuccessEmpty : HomeUiState

    data class Error(val message: String) : HomeUiState
}