package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.muammarahlnn.lsv.core.util.createRoute
import com.muammarahlnn.lsv.core.util.navigateRoute

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewNavigation, 12/05/2024 00.45
 */
private const val CLASS_OVERVIEW_ROUTE = "class_overview"
const val OVERVIEW_SCREEN_ARG = "overview_screen"
val CLASS_OVERVIEW_FULL_ROUTE = createRoute(
    CLASS_OVERVIEW_ROUTE,
    CLASS_ID_ARG,
    OVERVIEW_SCREEN_ARG,
)

fun NavController.navigateToClassOverview(
    classId: String,
    overviewScreenOrdinal: Int,
    navOptions: NavOptions? = null,
) {
    navigate(
        route = navigateRoute(CLASS_OVERVIEW_ROUTE, classId, overviewScreenOrdinal),
        navOptions = navOptions,
    )
}

enum class ClassOverviewScreen {
    MODULE,
    ASSIGNMENT,
    QUIZ,
}