package com.muammarahlnn.lsv.ui.classoverview.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.CLASS_ID_ARG
import com.muammarahlnn.lsv.core.navigation.CLASS_OVERVIEW_FULL_ROUTE
import com.muammarahlnn.lsv.core.navigation.OVERVIEW_SCREEN_ARG
import com.muammarahlnn.lsv.ui.classoverview.ClassOverviewFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewNavigation, 12/05/2024 02.52
 */
fun NavGraphBuilder.moduleFragment() {
    fragment<ClassOverviewFragment>(CLASS_OVERVIEW_FULL_ROUTE) {
        label = "Module"
        addClassOverviewArguments()
    }
}

fun NavGraphBuilder.assignmentFragment() {
    fragment<ClassOverviewFragment>(CLASS_OVERVIEW_FULL_ROUTE) {
        label = "Assignment"
        addClassOverviewArguments()
    }
}

fun NavGraphBuilder.quizFragment() {
    fragment<ClassOverviewFragment>(CLASS_OVERVIEW_FULL_ROUTE) {
        label = "Quiz"
        addClassOverviewArguments()
    }
}

fun FragmentNavigatorDestinationBuilder.addClassOverviewArguments() {
    argument(CLASS_ID_ARG) {
        type = NavType.StringType
    }
    argument(OVERVIEW_SCREEN_ARG) {
        type = NavType.IntType
    }
}