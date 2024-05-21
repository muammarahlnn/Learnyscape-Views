package com.muammarahlnn.lsv.ui.classnavigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.WindowCompat
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import com.muammarahlnn.lsv.core.navigation.CLASS_FEED_FULL_ROUTE
import com.muammarahlnn.lsv.core.navigation.CLASS_ID_ARG
import com.muammarahlnn.lsv.core.navigation.CLASS_MEMBER_FULL_ROUTE
import com.muammarahlnn.lsv.core.navigation.CLASS_OVERVIEW_FULL_ROUTE
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen
import com.muammarahlnn.lsv.core.navigation.navigateToClassFeed
import com.muammarahlnn.lsv.core.navigation.navigateToClassMember
import com.muammarahlnn.lsv.core.navigation.navigateToClassOverview
import com.muammarahlnn.lsv.core.ui.ext.readColor
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.classfeed.navigation.classFeedFragment
import com.muammarahlnn.lsv.ui.classmember.navigation.classMemberFragment
import com.muammarahlnn.lsv.ui.classnavigator.databinding.ScreenClassNavigatorBinding
import com.muammarahlnn.lsv.ui.classoverview.navigation.assignmentFragment
import com.muammarahlnn.lsv.ui.classoverview.navigation.moduleFragment
import com.muammarahlnn.lsv.ui.classoverview.navigation.quizFragment
import dagger.hilt.android.AndroidEntryPoint
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassNavigatorFragment, 11/05/2024 19.26
 */
@AndroidEntryPoint
internal class ClassNavigatorFragment :
    BaseFragment<ScreenClassNavigatorBinding, ClassNavigatorViewModel, ClassNavigatorState>() {

    override val viewModel: ClassNavigatorViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenClassNavigatorBinding {
        return ScreenClassNavigatorBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: ClassNavigatorState) {
    }

    private fun setupView() {
        setStatusBarColorToWhite()

        val classId = arguments?.getString(CLASS_ID_ARG) as String
        val navController = requireActivity().findNavController(R.id.classNavHost).apply {
            setGraph(
                graph = navController.createGraph(
                    startDestination = CLASS_FEED_FULL_ROUTE
                ) {
                    classFeedFragment()
                    moduleFragment()
                    assignmentFragment()
                    quizFragment()
                    classMemberFragment()
                },
                startDestinationArgs = Bundle().apply {
                    putString(CLASS_ID_ARG, classId)
                },
            )
        }

        viewBinding.classNavView.also { navView ->
            navView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigationFeed -> navController.navigateToClassFeed(
                        classId = classId,
                        navOptions = buildClassNavigatorNavOptions(CLASS_FEED_FULL_ROUTE),
                    )

                    R.id.navigationModule -> navController.navigateToClassOverview(
                        classId = classId,
                        overviewScreenOrdinal = ClassOverviewScreen.MODULE.ordinal,
                        navOptions = buildClassNavigatorNavOptions(CLASS_OVERVIEW_FULL_ROUTE),
                    )

                    R.id.navigationAssignment -> navController.navigateToClassOverview(
                        classId = classId,
                        overviewScreenOrdinal = ClassOverviewScreen.ASSIGNMENT.ordinal,
                        navOptions = buildClassNavigatorNavOptions(CLASS_OVERVIEW_FULL_ROUTE),
                    )

                    R.id.navigationQuiz -> navController.navigateToClassOverview(
                        classId = classId,
                        overviewScreenOrdinal = ClassOverviewScreen.QUIZ.ordinal,
                        navOptions = buildClassNavigatorNavOptions(CLASS_OVERVIEW_FULL_ROUTE),
                    )

                    R.id.navigationMember -> navController.navigateToClassMember(
                        classId = classId,
                        navOptions = buildClassNavigatorNavOptions(CLASS_MEMBER_FULL_ROUTE),
                    )
                }
                true
            }
        }
    }

    private fun buildClassNavigatorNavOptions(popUpToRoute: String): NavOptions = navOptions {
        popUpTo(popUpToRoute)
        launchSingleTop = true
        restoreState = true
    }

    private fun setStatusBarColorToWhite() {
        requireActivity().window.apply {
            statusBarColor = readColor(uiR.color.white)

            WindowCompat.getInsetsController(this, decorView).apply {
                isAppearanceLightStatusBars = true
                navigationBarColor = readColor(uiR.color.black)
            }
        }
    }
}