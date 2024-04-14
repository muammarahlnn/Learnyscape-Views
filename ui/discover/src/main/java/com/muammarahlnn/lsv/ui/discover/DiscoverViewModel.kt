package com.muammarahlnn.lsv.ui.discover

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.discover.GetAvailableClassesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverViewModel, 19/03/2024 02.19
 */
@HiltViewModel
internal class DiscoverViewModel @Inject constructor(
    private val getAvailableClassesUseCase: GetAvailableClassesUseCase,
    initialState: DiscoverUiState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<DiscoverUiState>(initialState, savedStateHandle) {

    fun fetchAvailableClasses() {
        getAvailableClassesUseCase.execute(
            params = GetAvailableClassesUseCase.Params(),
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    DiscoverUiState.FetchLoading(true)
                }
            },
            onSuccess = { availableClasses ->
                updateState {
                    DiscoverUiState.Success(availableClasses)
                }
            },
            onError = { throwable ->
                updateState {
                    DiscoverUiState.Error(throwable.message.toString())
                }
            },
            onCompletion = {
                updateState {
                    DiscoverUiState.FetchLoading(false)
                }
            },
        )
    }
}