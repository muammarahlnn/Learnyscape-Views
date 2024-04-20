package com.muammarahlnn.lsv.ui.pendingrequest

import com.muammarahlnn.lsv.core.model.PendingRequestModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestUiState, 21/04/2024 02.59
 */
internal sealed interface PendingRequestUiState {

    data class OnFetchPendingRequests(val fetching: Boolean) : PendingRequestUiState

    data class OnSuccessFetchingPendingRequests(
        val pendingRequests: List<PendingRequestModel>
    ) : PendingRequestUiState

    data class OnErrorFetchPendingRequests(val message: String) : PendingRequestUiState

    data class OnCancelRequestJoinClass(val loading: Boolean) : PendingRequestUiState

    data class OnSuccessCancelRequestJoinClass(val className: String) : PendingRequestUiState

    data class OnErrorCancelRequestJoinClass(val message: String) : PendingRequestUiState
}