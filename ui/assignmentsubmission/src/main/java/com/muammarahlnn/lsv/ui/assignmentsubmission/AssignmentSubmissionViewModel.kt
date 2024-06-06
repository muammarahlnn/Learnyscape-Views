package com.muammarahlnn.lsv.ui.assignmentsubmission

import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionViewModel, 05/06/2024 02.12
 */
@HiltViewModel
class AssignmentSubmissionViewModel @Inject constructor(
    initialState: AssignmentSubmissionState,
) : BaseViewModel<AssignmentSubmissionState>(initialState)