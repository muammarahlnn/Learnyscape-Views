package com.muammarahlnn.lsv.ui.assignmentsubmission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.muammarahlnn.lsv.core.ui.ext.dpToPx
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.assignmentsubmission.databinding.SheetAssignmentSubmissionBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionSheet, 05/06/2024 01.20
 */
@AndroidEntryPoint
class AssignmentSubmissionSheet :
    BaseFragment<SheetAssignmentSubmissionBinding, AssignmentSubmissionViewModel, AssignmentSubmissionState>() {


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

    override fun renderState(state: AssignmentSubmissionState) {}

    private fun setupView() {
        val behavior = BottomSheetBehavior.from(viewBinding.root.parent as View).apply {
            addBottomSheetCallback(object : BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_COLLAPSED -> {
                            viewBinding.expandedContent.root.hide()
                            viewBinding.llAttachments.show()
                        }

                        BottomSheetBehavior.STATE_EXPANDED -> {
                            viewBinding.expandedContent.root.show()
                            viewBinding.llAttachments.hide()
                        }

                        else -> Unit
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })

            state = BottomSheetBehavior.STATE_COLLAPSED
            peekHeight = requireContext().dpToPx(240)
        }

        viewBinding.llAttachments.setOnClickListener {
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}