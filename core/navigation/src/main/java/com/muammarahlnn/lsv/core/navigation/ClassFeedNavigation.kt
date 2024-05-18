package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.muammarahlnn.lsv.core.util.createRoute
import com.muammarahlnn.lsv.core.util.navigateRoute

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedNavigation, 12/05/2024 00.45
 */
private const val CLASS_FEED_ROUTE = "class_feed"
val CLASS_FEED_FULL_ROUTE = createRoute(
    CLASS_FEED_ROUTE,
    CLASS_ID_ARG,
)

fun NavController.navigateToClassFeed(
    classId: String,
    navOptions: NavOptions? = null
) {
    navigate(
        route = navigateRoute(CLASS_FEED_ROUTE, classId),
        navOptions = navOptions,
    )
}