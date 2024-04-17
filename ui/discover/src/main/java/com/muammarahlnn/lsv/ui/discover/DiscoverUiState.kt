package com.muammarahlnn.lsv.ui.discover

import com.muammarahlnn.lsv.core.model.AvailableClassModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverState, 19/03/2024 02.19
 */
internal sealed interface DiscoverUiState {

    data class OnFetchAvailableClasses(val loading: Boolean) : DiscoverUiState

    data class OnSuccessFetchAvailableClasses(val availableClasses: List<AvailableClassModel>) : DiscoverUiState

    data class OnErrorFetchAvailableClasses(val message: String) : DiscoverUiState

    data class OnRequestJoinClass(val loading : Boolean) : DiscoverUiState

    data class OnSuccessRequestJoinClass(
        val className: String,
        val isCancelRequest: Boolean,
    ) : DiscoverUiState

    data class OnErrorRequestJoinClass(val message: String) : DiscoverUiState
}