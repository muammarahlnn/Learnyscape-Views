package com.muammarahlnn.lsv.ui.discover

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.model.AvailableClassModel
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.discover.CancelRequestJoinClassUseCase
import com.muammarahlnn.lsv.domain.discover.GetAvailableClassesUseCase
import com.muammarahlnn.lsv.domain.discover.RequestJoinClassUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverViewModel, 19/03/2024 02.19
 */
@HiltViewModel
internal class DiscoverViewModel @Inject constructor(
    private val getAvailableClassesUseCase: GetAvailableClassesUseCase,
    private val requestJoinClassUseCase: RequestJoinClassUseCase,
    private val cancelRequestJoinClassUseCase: CancelRequestJoinClassUseCase,
    initialState: DiscoverUiState,
) : BaseViewModel<DiscoverUiState>(initialState) {

    fun fetchAvailableClasses() {
        getAvailableClassesUseCase.execute(
            params = GetAvailableClassesUseCase.Params(),
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    DiscoverUiState.OnFetchAvailableClasses(true)
                }
            },
            onSuccess = { availableClasses ->
                updateState {
                    DiscoverUiState.OnSuccessFetchAvailableClasses(availableClasses)
                }
            },
            onError = { throwable ->
                updateState {
                    DiscoverUiState.OnErrorFetchAvailableClasses(throwable.message.toString())
                }
            },
            onCompletion = {
                updateState {
                    DiscoverUiState.OnFetchAvailableClasses(false)
                }
            },
        )
    }

    fun requestJoinClass(availableClass: AvailableClassModel) {
        requestJoinClassUseCase.execute(
            params = RequestJoinClassUseCase.Params(classId = availableClass.id),
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    DiscoverUiState.OnRequestJoinClass(true)
                }
            },
            onSuccess = {
                updateState {
                    DiscoverUiState.OnSuccessRequestJoinClass(
                        className = availableClass.name,
                        isCancelRequest = false,
                    )
                }
            },
            onError = {
                updateState {
                    DiscoverUiState.OnErrorRequestJoinClass(it.message.toString())
                }
            },
            onCompletion = {
                updateState {
                    DiscoverUiState.OnRequestJoinClass(false)
                }
                fetchAvailableClasses()
            },
        )
    }

    fun cancelRequestJoinClass(availableClass: AvailableClassModel) {
        cancelRequestJoinClassUseCase.execute(
            params = CancelRequestJoinClassUseCase.Params(classId = availableClass.id),
            coroutineScope = viewModelScope,
            onStart = {
                DiscoverUiState.OnRequestJoinClass(true)
            },
            onSuccess = {
                updateState {
                    DiscoverUiState.OnSuccessRequestJoinClass(
                        className = availableClass.name,
                        isCancelRequest = true,
                    )
                }
            },
            onError = {
                updateState {
                    DiscoverUiState.OnErrorRequestJoinClass(it.message.toString())
                }
            },
            onCompletion = {
                updateState {
                    DiscoverUiState.OnRequestJoinClass(false)
                }
                fetchAvailableClasses()
            },
        )
    }
}