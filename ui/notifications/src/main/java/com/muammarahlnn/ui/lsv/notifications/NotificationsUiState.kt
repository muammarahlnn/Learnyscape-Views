package com.muammarahlnn.ui.lsv.notifications

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsUiState, 20/04/2024 15.45
 */
internal sealed interface NotificationsUiState {

    data object Loading : NotificationsUiState
}