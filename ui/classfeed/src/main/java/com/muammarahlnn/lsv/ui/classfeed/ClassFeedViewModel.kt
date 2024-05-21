package com.muammarahlnn.lsv.ui.classfeed

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.classfeed.GetClassDetailsUseCase
import com.muammarahlnn.lsv.domain.classfeed.GetClassFeedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedViewModel, 12/05/2024 02.38
 */
@HiltViewModel
internal class ClassFeedViewModel @Inject constructor(
    private val getClassDetailsUseCase: GetClassDetailsUseCase,
    private val getClassFeedsUseCase: GetClassFeedsUseCase,
    initialState: ClassFeedUiState,
) : BaseViewModel<ClassFeedUiState>(initialState) {

    fun fetchClassDetails(classId: String) {
        getClassDetailsUseCase.execute(
            params = GetClassDetailsUseCase.Params(
                classId = classId,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ClassFeedUiState.LoadingFetchDetails(true) }
            },
            onSuccess = { classDetails ->
                updateState { ClassFeedUiState.SuccessFetchDetails(classDetails) }
            },
            onError = { throwable ->
                updateState { ClassFeedUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ClassFeedUiState.LoadingFetchDetails(false) }
            },
        )
    }

    fun fetchClassFeeds(classId: String) {
        getClassFeedsUseCase.execute(
            params = GetClassFeedsUseCase.Params(
                classId = classId,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ClassFeedUiState.LoadingFetchFeeds(true) }
            },
            onSuccess = { classFeeds ->
                updateState { ClassFeedUiState.SuccessFetchFeeds(classFeeds) }
            },
            onError = { throwable ->
                updateState { ClassFeedUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ClassFeedUiState.LoadingFetchFeeds(false) }
            },
        )
    }
}