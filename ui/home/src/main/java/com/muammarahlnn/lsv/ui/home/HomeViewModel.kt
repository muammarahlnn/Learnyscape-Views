package com.muammarahlnn.lsv.ui.home

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.home.GetEnrolledClassesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeViewModel, 19/03/2024 02.35
 */
@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getEnrolledClassesUseCase: GetEnrolledClassesUseCase,
    initialState: HomeUiState,
) : BaseViewModel<HomeUiState>(initialState) {

    fun fetchEnrolledClasses() {
        getEnrolledClassesUseCase.execute(
            params = Unit,
            coroutineScope = viewModelScope,
            onStart = {
                updateState { HomeUiState.Loading }
            },
            onSuccess = { enrolledClasses ->
                updateState {
                    if (enrolledClasses.isNotEmpty()) HomeUiState.Success(enrolledClasses)
                    else HomeUiState.SuccessEmpty
                }
            },
            onError = { throwable ->
                updateState { HomeUiState.Error(throwable.message.toString()) }
            }
        )
    }
}