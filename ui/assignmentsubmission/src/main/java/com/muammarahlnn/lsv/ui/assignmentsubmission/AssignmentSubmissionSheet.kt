package com.muammarahlnn.lsv.ui.assignmentsubmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.muammarahlnn.lsv.core.model.AssignmentSubmissionModel
import com.muammarahlnn.lsv.core.ui.ext.dpToPx
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.openFile
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.assignmentsubmission.adapter.SubmissionAttachmentAdapter
import com.muammarahlnn.lsv.ui.assignmentsubmission.databinding.SheetAssignmentSubmissionBinding
import com.muammarahlnn.lsv.ui.assignmentsubmission.listener.AssignmentSubmissionSheetListener
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionSheet, 05/06/2024 01.20
 */
@AndroidEntryPoint
class AssignmentSubmissionSheet :
    BaseFragment<SheetAssignmentSubmissionBinding, AssignmentSubmissionViewModel, AssignmentSubmissionUiState>() {

    override val viewModel: AssignmentSubmissionViewModel by viewModels()

    private lateinit var sheetBehavior: BottomSheetBehavior<View>

    /**
     * the listener is guaranteed initialized when attached
     * from the ResourceDetailsFragment's fragment manager
     */
    private lateinit var assignmentSubmissionSheetListener: AssignmentSubmissionSheetListener

    private val submissionAttachmentAdapter: SubmissionAttachmentAdapter by lazy {
        SubmissionAttachmentAdapter { attachment ->
            requireActivity().openFile(attachment)
        }
    }

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): SheetAssignmentSubmissionBinding {
        return SheetAssignmentSubmissionBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupArguments()
        setupView()
        if (savedInstanceState == null) {
            viewModel.fetchAssignmentSubmission()
        }
    }

    override fun renderState(state: AssignmentSubmissionUiState) {
        when (state) {
            is AssignmentSubmissionUiState.OnLoadingFetchStudentSubmission ->
                renderLoadingFetchStudentSubmissionState(state.loading)

            is AssignmentSubmissionUiState.OnStudentSubmissionFetched ->
                renderOnSubmissionAttachmentsFetched(state.assignmentSubmissionModel)

            is AssignmentSubmissionUiState.OnErrorFetchStudentSubmission ->
                showMessage(state.message)
        }
    }

    fun setAssignmentSubmissionSheetListener(listener: AssignmentSubmissionSheetListener) {
        assignmentSubmissionSheetListener = listener
    }

    private fun setupArguments() {
        requireArguments().getString(ASSIGNMENT_ID_ARG)?.let { viewModel.assignmentId = it }
    }

    private fun setupView() {
        sheetBehavior = BottomSheetBehavior.from(viewBinding.root.parent as View).apply {
            state = BottomSheetBehavior.STATE_COLLAPSED
        }

        viewBinding.collapsedContent.root.setOnClickListener {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun renderLoadingFetchStudentSubmissionState(loading: Boolean) {
        assignmentSubmissionSheetListener.onLoading(loading)
    }

    private fun renderOnSubmissionAttachmentsFetched(assignmentSubmission: AssignmentSubmissionModel) {
        showCollapsedContent(assignmentSubmission.attachments.size)

        sheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED ->
                        showCollapsedContent(assignmentSubmission.attachments.size)

                    BottomSheetBehavior.STATE_EXPANDED ->
                        showExpandedContent(assignmentSubmission.attachments)

                    else -> Unit
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    private fun showCollapsedContent(attachmentsSize: Int) {
        viewBinding.expandedContent.root.hide()
        if (attachmentsSize > 0) {
            with(viewBinding.collapsedContent) {
                root.show()
                tvSeeAttachments.text = if (attachmentsSize > 1) {
                    readText(R.string.see_attachments, attachmentsSize)
                } else {
                    readText(R.string.see_attachment)
                }
            }

            sheetBehavior.peekHeight = requireContext().dpToPx(240)
        }
    }

    private fun showExpandedContent(attachments: List<File>) {
        viewBinding.collapsedContent.root.hide()
        viewBinding.expandedContent.apply {
            root.show()
            if (attachments.isNotEmpty()) {
                rvAttachments.adapter = submissionAttachmentAdapter.apply {
                    setItems(attachments)
                }
                llAddWorkIllustration.hide()
            } else {
                rvAttachments.hide()
                llSaveWork.hide()
            }
        }
    }

    companion object {

        const val ASSIGNMENT_ID_ARG = "assignment_id"
    }
}