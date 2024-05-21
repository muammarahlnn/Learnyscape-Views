package com.muammarahlnn.lsv.ui.classfeed

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.ClassDetailsModel
import com.muammarahlnn.lsv.core.model.ClassFeedModel
import com.muammarahlnn.lsv.core.navigation.CLASS_ID_ARG
import com.muammarahlnn.lsv.core.navigation.getRootNavController
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.readColor
import com.muammarahlnn.lsv.core.ui.ext.readFont
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.core.ui.util.toDisplayedTime
import com.muammarahlnn.lsv.ui.classfeed.adapter.ClassFeedAdapter
import com.muammarahlnn.lsv.ui.classfeed.databinding.ScreenClassFeedBinding
import dagger.hilt.android.AndroidEntryPoint
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedFragment, 12/05/2024 02.37
 */
@AndroidEntryPoint
internal class ClassFeedFragment :
    BaseFragment<ScreenClassFeedBinding, ClassFeedViewModel, ClassFeedUiState>() {

    override val viewModel: ClassFeedViewModel by viewModels()

    private val classFeedAdapter by lazy {
        ClassFeedAdapter { classFeed ->
            showMessage(classFeed.name)
        }
    }

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenClassFeedBinding {
        return ScreenClassFeedBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            val classId = arguments?.getString(CLASS_ID_ARG) as String
            viewModel.fetchClassDetails(classId)
            viewModel.fetchClassFeeds(classId)
        }
    }

    override fun renderState(state: ClassFeedUiState) {
        when (state) {
            is ClassFeedUiState.LoadingFetchDetails ->
                renderLoadingFetchDetailsState(state.loading)

            is ClassFeedUiState.SuccessFetchDetails ->
                renderSuccessFetchDetailsState(state.classDetails)

            is ClassFeedUiState.LoadingFetchFeeds ->
                renderLoadingFetchFeedsState(state.loading)

            is ClassFeedUiState.SuccessFetchFeeds ->
                renderSuccessFetchFeedsState(state.classFeeds)

            is ClassFeedUiState.Error ->
                showMessage(state.message)
        }
    }

    private fun setupView() {
        viewBinding.ivBack.also { view ->
            view.setOnClickListener {
                requireActivity().getRootNavController().navigateUp()
            }
        }
    }

    private fun renderLoadingFetchDetailsState(loading: Boolean) {
        with(viewBinding) {
            if (loading) {
                shimmerLoadingDetails.root.show()
                classInfoCard.hide()
            } else {
                shimmerLoadingDetails.root.hide()
                classInfoCard.show()
            }
        }
    }

    private fun renderLoadingFetchFeedsState(loading: Boolean) {
        viewBinding.shimmerLoadingFeeds.root.also { view ->
            if (loading) view.show() else view.hide()
        }
    }

    private fun renderSuccessFetchDetailsState(classDetails: ClassDetailsModel) {
        with(viewBinding) {
            tvClassName.text = classDetails.name
            tvClassDate.text = readText(
                R.string.class_time,
                classDetails.day.displayedText,
                classDetails.startTime.toDisplayedTime(),
                classDetails.endTime.toDisplayedTime(),
            )

            val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            classDetails.lecturers.forEach { lecturer ->
                val tvLecturer = TextView(context).apply {
                    this.layoutParams = layoutParams
                    text = lecturer.fullName
                    typeface = readFont(uiR.font.poppins_medium)
                    setTextColor(readColor(uiR.color.gray))
                    maxLines = 1
                    ellipsize = TextUtils.TruncateAt.END
                    includeFontPadding = false
                }
                llLecturers.addView(tvLecturer)
            }
        }
    }

    private fun renderSuccessFetchFeedsState(classFeeds: List<ClassFeedModel>) {
        viewBinding.rvClassFeeds.apply {
            adapter = classFeedAdapter.apply {
                setFeeds(classFeeds)
            }
        }
    }
}