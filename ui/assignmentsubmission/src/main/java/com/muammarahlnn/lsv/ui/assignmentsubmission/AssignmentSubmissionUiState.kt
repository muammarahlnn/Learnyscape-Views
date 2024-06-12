package com.muammarahlnn.lsv.ui.assignmentsubmission

import com.muammarahlnn.lsv.core.model.AssignmentSubmissionModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionState, 05/06/2024 02.12
 */
sealed interface AssignmentSubmissionUiState {

    data class OnLoadingFetchStudentSubmission(val loading: Boolean) : AssignmentSubmissionUiState

    data class OnStudentSubmissionFetched(
        val assignmentSubmissionModel: AssignmentSubmissionModel,
    ) : AssignmentSubmissionUiState

    data class OnErrorFetchStudentSubmission(val message: String) : AssignmentSubmissionUiState
}