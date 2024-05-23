package com.muammarahlnn.lsv.ui.resourcedetails

import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel
import com.muammarahlnn.lsv.core.model.QuizDetailsModel
import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsState, 22/05/2024 21.07
 */
internal sealed interface ResourceDetailsUiState {

    data class LoadingFetchDetails(val loading: Boolean) : ResourceDetailsUiState

    data class SuccessFetchDetails(val resourceDetails: ResourceDetailsState) : ResourceDetailsUiState

    data class Error(val message: String) : ResourceDetailsUiState
}

internal data class ResourceDetailsState(
    val resourceType: ClassResourceTypeModel = ClassResourceTypeModel.ANNOUNCEMENT,
    val name: String = "",
    val date: String = "",
    val description: String = "",
    val attachments: List<File> = emptyList(),
    val startQuizDate: String = "",
    val endQuizDate: String = "",
    val quizDuration: Int = 0,
    val quizType: QuizDetailsModel.QuizType = QuizDetailsModel.QuizType.MULTIPLE_CHOICE,
)