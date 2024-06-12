package com.muammarahlnn.lsv.ui.assignmentsubmission

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.model.AssignmentSubmissionModel
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.assignmentsubmission.StudentGetAssignmentSubmissionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionViewModel, 05/06/2024 02.12
 */
@HiltViewModel
class AssignmentSubmissionViewModel @Inject constructor(
    private val studentGetAssignmentSubmissionUseCase: StudentGetAssignmentSubmissionUseCase,
    initialState: AssignmentSubmissionUiState,
) : BaseViewModel<AssignmentSubmissionUiState>(initialState) {

    lateinit var assignmentId: String

    fun fetchAssignmentSubmission() {
        studentGetAssignmentSubmissionUseCase.execute(
            params = StudentGetAssignmentSubmissionUseCase.Params(
                assignmentId = assignmentId,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState {
                    AssignmentSubmissionUiState.OnLoadingFetchStudentSubmission(true)
                }
            },
            onSuccess = { assignmentSubmissionModel ->
                updateState {
                    AssignmentSubmissionUiState.OnStudentSubmissionFetched(assignmentSubmissionModel)
                }
            },
            onError = { throwable ->
                if (throwable is HttpException) {
                    handleNotFoundError(throwable)
                } else {
                    updateState {
                        AssignmentSubmissionUiState.OnErrorFetchStudentSubmission(throwable.message.toString())
                    }
                }
            },
            onCompletion = {
                updateState {
                    AssignmentSubmissionUiState.OnLoadingFetchStudentSubmission(false)
                }
            }
        )
    }

    private fun handleNotFoundError(exception: HttpException) {
        val responseBody = exception.response()?.errorBody()?.string()
        val json = Json { ignoreUnknownKeys = true }
        responseBody?.let { response ->
            val code = json.decodeFromString<ErrorResponse>(response).error.code.orEmpty()
            val notFoundErrorCode = "E444"
            if (code.equals(notFoundErrorCode, true)) {
                updateState {
                    AssignmentSubmissionUiState.OnStudentSubmissionFetched(AssignmentSubmissionModel())
                }
            }
        }
    }
}

@Serializable
data class ErrorResponse(
    val error: Error,
) {
    @Serializable
    data class Error(val code: String? = null)
}