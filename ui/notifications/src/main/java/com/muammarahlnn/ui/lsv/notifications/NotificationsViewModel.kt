package com.muammarahlnn.ui.lsv.notifications

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.notifications.GetNotificationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsViewModel, 20/04/2024 15.46
 */
@HiltViewModel
internal class NotificationsViewModel @Inject constructor(
    private val getNotificationsUseCase: GetNotificationsUseCase,
    initialState: NotificationsUiState,
) : BaseViewModel<NotificationsUiState>(initialState) {

    fun fetchNotifications() {
        getNotificationsUseCase.execute(
            params = Unit,
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    NotificationsUiState.OnFetchNotifications(true)
                }
            },
            onSuccess = { notifications ->
                updateState {
                    NotificationsUiState.OnSuccessFetchNotifications(notifications)
                }
            },
            onError = { throwable ->
                updateState {
                    NotificationsUiState.OnErrorFetchNotifications(throwable?.message.toString())
                }
            },
            onCompletion = {
                updateState {
                    NotificationsUiState.OnFetchNotifications(false)
                }
            }
        )
    }
}