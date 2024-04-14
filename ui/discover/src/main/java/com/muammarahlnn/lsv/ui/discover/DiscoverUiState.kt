package com.muammarahlnn.lsv.ui.discover

import com.muammarahlnn.lsv.core.model.AvailableClassModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverState, 19/03/2024 02.19
 */
internal sealed interface DiscoverUiState {

    data class FetchLoading(val loading: Boolean) : DiscoverUiState

    data class Success(val availableClasses: List<AvailableClassModel>) : DiscoverUiState

    data class Error(val message: String) : DiscoverUiState
}