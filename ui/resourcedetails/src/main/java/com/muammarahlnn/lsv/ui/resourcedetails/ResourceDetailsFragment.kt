package com.muammarahlnn.lsv.ui.resourcedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.WindowCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.ANNOUNCEMENT
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.ASSIGNMENT
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.MODULE
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.QUIZ
import com.muammarahlnn.lsv.core.model.QuizDetailsModel.QuizType.MULTIPLE_CHOICE
import com.muammarahlnn.lsv.core.model.QuizDetailsModel.QuizType.PHOTO_ANSWER
import com.muammarahlnn.lsv.core.navigation.RESOURCE_ID_ARG
import com.muammarahlnn.lsv.core.navigation.RESOURCE_TYPE_ORDINAL_ARG
import com.muammarahlnn.lsv.core.navigation.getRootNavController
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.invisible
import com.muammarahlnn.lsv.core.ui.ext.openFile
import com.muammarahlnn.lsv.core.ui.ext.readColor
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.assignmentsubmission.AssignmentSubmissionSheet
import com.muammarahlnn.lsv.ui.resourcedetails.adapter.AttachmentAdapter
import com.muammarahlnn.lsv.ui.resourcedetails.databinding.ScreenResourceDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsFragment, 22/05/2024 21.06
 */
@AndroidEntryPoint
internal class ResourceDetailsFragment :
    BaseFragment<ScreenResourceDetailsBinding, ResourceDetailsViewModel, ResourceDetailsUiState>() {

    override val viewModel: ResourceDetailsViewModel by viewModels()

    private val attachmentAdapter: AttachmentAdapter by lazy {
        AttachmentAdapter { attachment ->
            requireActivity().openFile(attachment)
        }
    }

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenResourceDetailsBinding {
        return ScreenResourceDetailsBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupArguments()
        setupView()
        if (savedInstanceState == null) {
            viewModel.fetchResourceDetails()
            if (viewModel.classResourceType == ASSIGNMENT) {
                setupAssignmentSubmissionSheet()
            }
        }
    }

    override fun renderState(state: ResourceDetailsUiState) {
        when (state) {
            is ResourceDetailsUiState.LoadingFetchDetails ->
                renderLoadingFetchDetailsState(state.loading)

            is ResourceDetailsUiState.SuccessFetchDetails ->
                renderSuccessFetchDetailsState(state.resourceDetails)

            is ResourceDetailsUiState.Error ->
                showMessage(state.message)
        }
    }

    private fun setupArguments() {
        val resourceId = arguments?.getString(RESOURCE_ID_ARG) as String
        viewModel.resourceId = resourceId

        val resourceTypeOrdinal = arguments?.getInt(RESOURCE_TYPE_ORDINAL_ARG) as Int
        viewModel.classResourceType = when (resourceTypeOrdinal) {
            ANNOUNCEMENT.ordinal -> ANNOUNCEMENT
            MODULE.ordinal -> MODULE
            ASSIGNMENT.ordinal -> ASSIGNMENT
            QUIZ.ordinal -> QUIZ
            else -> throw IllegalArgumentException()
        }
    }

    private fun setupView() {
        setStatusBarColorToRed()

        viewBinding.toolbar.ivBack.also { view ->
            view.setOnClickListener {
                requireActivity().getRootNavController().navigateUp()
            }
        }

        when (viewModel.classResourceType) {
            ANNOUNCEMENT -> {
                viewBinding.toolbar.tvTitle.text = readText(R.string.announcement)
                viewBinding.ivResourceType.invisible()
                viewBinding.ivProfilePic.show()
            }

            MODULE -> {
                viewBinding.toolbar.tvTitle.text = readText(R.string.module)
                viewBinding.ivResourceType.setImageResource(uiR.drawable.ic_book_border)
            }

            ASSIGNMENT -> {
                viewBinding.toolbar.tvTitle.text = readText(R.string.assignment)
                viewBinding.ivResourceType.setImageResource(uiR.drawable.ic_assignment_border)
            }

            QUIZ -> {
                viewBinding.toolbar.tvTitle.text = readText(R.string.quiz)
                viewBinding.ivResourceType.setImageResource(uiR.drawable.ic_quiz_border)
            }
        }
    }

    private fun setStatusBarColorToRed() {
        requireActivity().window.apply {
            statusBarColor = readColor(uiR.color.red)

            // set to dark status bar
            WindowCompat.getInsetsController(this, decorView).apply {
                isAppearanceLightStatusBars = false
                navigationBarColor = readColor(uiR.color.black)
            }
        }
    }

    private fun renderLoadingFetchDetailsState(loading: Boolean) {
        with(viewBinding) {
            if (loading) {
                progressBar.show()
                resourceDetailsCard.hide()
                attachmentsCard.hide()
            } else {
                progressBar.hide()
                resourceDetailsCard.show()
                attachmentsCard.show()
            }
        }
    }

    private fun renderSuccessFetchDetailsState(resourceDetails: ResourceDetailsState) {
        with(viewBinding) {
            tvName.text = resourceDetails.name
            tvDate.text = resourceDetails.date
            tvDesc.text = resourceDetails.description

            when (viewModel.classResourceType) {
                QUIZ -> {
                    attachmentsCard.hide()
                    quizDetailsCard.also { view ->
                        view.root.show()
                        view.tvQuizTime.text = readText(
                            R.string.quiz_time,
                            resourceDetails.startQuizDate,
                            resourceDetails.endQuizDate,
                        )
                        view.tvQuizDuration.text = resourceDetails.quizDuration.toString()
                        view.tvQuizType.text = readText(
                            when (resourceDetails.quizType) {
                                MULTIPLE_CHOICE -> R.string.multiple_choice
                                PHOTO_ANSWER -> R.string.photo_answer
                            }
                        )
                    }
                }

                else -> rvAttachments.apply {
                    adapter = attachmentAdapter.apply {
                        setItems(resourceDetails.attachments)
                    }
                }
            }

        }
    }

    private fun setupAssignmentSubmissionSheet() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            add<AssignmentSubmissionSheet>(R.id.assignmentSubmissionSheetContainer)
        }
    }
}