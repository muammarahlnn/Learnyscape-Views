package com.muammarahlnn.lsv.ui.classoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.navigation.CLASS_ID_ARG
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen
import com.muammarahlnn.lsv.core.navigation.OVERVIEW_SCREEN_ARG
import com.muammarahlnn.lsv.core.navigation.getRootNavController
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.classoverview.databinding.ScreenClassOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewFragment, 12/05/2024 00.10
 */
@AndroidEntryPoint
internal class ClassOverviewFragment :
    BaseFragment<ScreenClassOverviewBinding, ClassOverviewViewModel, ClassOverviewState>() {

    override val viewModel: ClassOverviewViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenClassOverviewBinding {
        return ScreenClassOverviewBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: ClassOverviewState) {
    }

    private fun setupView() {
        val classId = arguments?.getString(CLASS_ID_ARG) as String
        val overviewScreenOrdinal = arguments?.getInt(OVERVIEW_SCREEN_ARG) as Int

        viewBinding.toolbar.ivBack.also { view ->
            view.setOnClickListener {
                requireActivity().getRootNavController().navigateUp()
            }
        }

        viewBinding.toolbar.tvTitle.also { view ->
            view.text = readText(
                when (overviewScreenOrdinal) {
                    ClassOverviewScreen.MODULE.ordinal -> R.string.module
                    ClassOverviewScreen.ASSIGNMENT.ordinal -> R.string.assignment
                    ClassOverviewScreen.QUIZ.ordinal -> R.string.quiz
                    else -> throw IllegalArgumentException("Overview screen ordinal not found")
                }
            )
        }
    }
}