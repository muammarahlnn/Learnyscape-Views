package com.muammarahlnn.lsv.ui.pendingrequest

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestUiState, 21/04/2024 02.59
 */
internal sealed interface PendingRequestUiState {

    data class OnFetchPendingRequests(val fetching: Boolean) : PendingRequestUiState
}