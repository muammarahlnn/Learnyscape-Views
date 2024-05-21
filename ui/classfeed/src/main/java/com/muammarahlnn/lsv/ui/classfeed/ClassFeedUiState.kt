package com.muammarahlnn.lsv.ui.classfeed

import com.muammarahlnn.lsv.core.model.ClassDetailsModel
import com.muammarahlnn.lsv.core.model.ClassFeedModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedState, 12/05/2024 02.37
 */
internal sealed interface ClassFeedUiState {

    data class LoadingFetchDetails(val loading: Boolean) : ClassFeedUiState

    data class SuccessFetchDetails(val classDetails: ClassDetailsModel) : ClassFeedUiState

    data class LoadingFetchFeeds(val loading: Boolean) : ClassFeedUiState

    data class SuccessFetchFeeds(val classFeeds: List<ClassFeedModel>) : ClassFeedUiState

    data class Error(val message: String) : ClassFeedUiState
}