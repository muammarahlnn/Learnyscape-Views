package com.muammarahlnn.lsv.ui.pendingrequest

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.model.PendingRequestModel
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.discover.CancelRequestJoinClassUseCase
import com.muammarahlnn.lsv.domain.pendingrequest.GetStudentPendingRequestsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestViewModel, 21/04/2024 03.02
 */
@HiltViewModel
internal class PendingRequestViewModel @Inject constructor(
    private val getStudentPendingRequestsUseCase: GetStudentPendingRequestsUseCase,
    private val cancelRequestJoinClassUseCase: CancelRequestJoinClassUseCase,
    initialState: PendingRequestUiState,
) : BaseViewModel<PendingRequestUiState>(initialState) {

    fun fetchPendingRequests() {
        getStudentPendingRequestsUseCase.execute(
            params = Unit,
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    PendingRequestUiState.OnFetchPendingRequests(true)
                }
            },
            onSuccess = { pendingRequests ->
                updateState {
                    PendingRequestUiState.OnSuccessFetchingPendingRequests(pendingRequests)
                }
            },
            onError = { throwable ->
                updateState {
                    PendingRequestUiState.OnErrorFetchPendingRequests(throwable.message.toString())
                }
            },
            onCompletion = {
                updateState {
                    PendingRequestUiState.OnFetchPendingRequests(false)
                }
            },
        )
    }

    fun cancelRequestJoinClass(pendingRequest: PendingRequestModel) {
        cancelRequestJoinClassUseCase.execute(
            params = CancelRequestJoinClassUseCase.Params(classId = pendingRequest.classId),
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    PendingRequestUiState.OnCancelRequestJoinClass(loading = true)
                }
            },
            onSuccess = {
                updateState {
                    PendingRequestUiState.OnSuccessCancelRequestJoinClass(pendingRequest.className)
                }
            },
            onError = { throwable ->
                updateState {
                    PendingRequestUiState.OnErrorCancelRequestJoinClass(throwable.message.toString())
                }
            },
            onCompletion = {
                updateState {
                    PendingRequestUiState.OnCancelRequestJoinClass(loading = false)
                }
                fetchPendingRequests()
            }
        )
    }
}