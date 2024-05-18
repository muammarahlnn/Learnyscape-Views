package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.muammarahlnn.lsv.core.util.createRoute
import com.muammarahlnn.lsv.core.util.navigateRoute

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewNavigation, 12/05/2024 00.45
 */
private const val MODULE_ROUTE = "module"
val MODULE_FULL_ROUTE = createRoute(
    MODULE_ROUTE,
    CLASS_ID_ARG,
)

fun NavController.navigateToModule(
    classId: String,
    navOptions: NavOptions? = null
) {
    navigate(
        route = navigateRoute(MODULE_ROUTE, classId),
        navOptions = navOptions,
    )
}

private const val ASSIGNMENT_ROUTE = "assignment"
val ASSIGNMENT_FULL_ROUTE = createRoute(
    ASSIGNMENT_ROUTE,
    CLASS_ID_ARG,
)

fun NavController.navigateToAssignment(
    classId: String,
    navOptions: NavOptions? = null
) {
    navigate(
        route = navigateRoute(ASSIGNMENT_ROUTE, classId),
        navOptions = navOptions,
    )
}

private const val QUIZ_ROUTE = "quiz"
val QUIZ_FULL_ROUTE = createRoute(
    QUIZ_ROUTE,
    CLASS_ID_ARG,
)

fun NavController.navigateToQuiz(
    classId: String,
    navOptions: NavOptions? = null
) {
    navigate(
        route = navigateRoute(QUIZ_ROUTE, classId),
        navOptions = navOptions,
    )
}


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