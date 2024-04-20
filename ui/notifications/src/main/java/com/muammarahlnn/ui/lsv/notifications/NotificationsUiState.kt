package com.muammarahlnn.ui.lsv.notifications

import com.muammarahlnn.lsv.core.model.NotificationModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsUiState, 20/04/2024 15.45
 */
internal sealed interface NotificationsUiState {

    data class OnFetchNotifications(val fetching: Boolean) : NotificationsUiState

    data class OnSuccessFetchNotifications(val notifications: List<NotificationModel>) : NotificationsUiState

    data class OnErrorFetchNotifications(val message: String) : NotificationsUiState
}