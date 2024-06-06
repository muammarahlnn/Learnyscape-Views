package com.muammarahlnn.lsv.ui.assignmentsubmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.sheet.BaseSheet
import com.muammarahlnn.lsv.ui.assignmentsubmission.databinding.SheetAssignmentSubmissionBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionSheet, 05/06/2024 01.20
 */
@AndroidEntryPoint
class AssignmentSubmissionSheet :
    BaseSheet<SheetAssignmentSubmissionBinding, AssignmentSubmissionViewModel, AssignmentSubmissionState>() {

    override val fullHeight: Boolean = false

    override val viewModel: AssignmentSubmissionViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): SheetAssignmentSubmissionBinding {
        return SheetAssignmentSubmissionBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {}
}