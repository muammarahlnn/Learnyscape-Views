package com.muammarahlnn.lsv.ui.classoverview

import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewState, 12/05/2024 00.10
 */
internal sealed interface ClassOverviewUiState {

    data class Loading(val loading: Boolean) : ClassOverviewUiState

    data class Success(val classResourceOverviews: List<ClassResourceOverviewModel>) : ClassOverviewUiState

    data class Error(val message: String) : ClassOverviewUiState
}