package com.muammarahlnn.lsv.ui.classoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel
import com.muammarahlnn.lsv.core.navigation.CLASS_ID_ARG
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.ASSIGNMENT
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.MODULE
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.QUIZ
import com.muammarahlnn.lsv.core.navigation.OVERVIEW_SCREEN_ARG
import com.muammarahlnn.lsv.core.navigation.getRootNavController
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.classoverview.adapter.ClassOverviewAdapter
import com.muammarahlnn.lsv.ui.classoverview.databinding.ScreenClassOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewFragment, 12/05/2024 00.10
 */
@AndroidEntryPoint
internal class ClassOverviewFragment :
    BaseFragment<ScreenClassOverviewBinding, ClassOverviewViewModel, ClassOverviewUiState>() {

    override val viewModel: ClassOverviewViewModel by viewModels()

    private val adapter: ClassOverviewAdapter by lazy {
        ClassOverviewAdapter(viewModel.classOverviewScreen) { classResourceOverview ->
            showMessage(classResourceOverview.name)
        }
    }

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenClassOverviewBinding {
        return ScreenClassOverviewBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            val classId = arguments?.getString(CLASS_ID_ARG) as String
            viewModel.fetchClassResourcesOverview(classId)
        }
    }

    override fun renderState(state: ClassOverviewUiState) {
        when (state) {
            is ClassOverviewUiState.Loading ->
                renderLoadingState(state.loading)

            is ClassOverviewUiState.Success ->
                renderSuccessState(state.classResourceOverviews)

            is ClassOverviewUiState.Error ->
                showMessage(state.message)
        }
    }

    private fun setupView() {
        val overviewScreenOrdinal = arguments?.getInt(OVERVIEW_SCREEN_ARG) as Int
        viewModel.classOverviewScreen = when (overviewScreenOrdinal) {
            MODULE.ordinal -> MODULE
            ASSIGNMENT.ordinal -> ASSIGNMENT
            QUIZ.ordinal -> QUIZ
            else -> throw IllegalArgumentException("Overview screen ordinal not found")
        }

        viewBinding.toolbar.ivBack.also { view ->
            view.setOnClickListener {
                requireActivity().getRootNavController().navigateUp()
            }
        }

        viewBinding.toolbar.tvTitle.also { view ->
            view.text = readText(
                when (viewModel.classOverviewScreen) {
                    MODULE -> R.string.module
                    ASSIGNMENT  -> R.string.assignment
                    QUIZ -> R.string.quiz
                }
            )
        }
    }

    private fun renderLoadingState(loading: Boolean) {
        viewBinding.shimmerLoading.root.also { view ->
            if (loading) view.show() else view.hide()
        }
    }

    private fun renderSuccessState(classResourceOverviews: List<ClassResourceOverviewModel>) {
        viewBinding.rvClassOverviews.apply {
            adapter = this@ClassOverviewFragment.adapter.apply {
                setItems(classResourceOverviews)
            }
        }
    }
}