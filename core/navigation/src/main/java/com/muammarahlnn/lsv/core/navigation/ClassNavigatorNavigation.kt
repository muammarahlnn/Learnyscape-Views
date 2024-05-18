package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import com.muammarahlnn.lsv.core.util.addSlidingAnim
import com.muammarahlnn.lsv.core.util.createRoute
import com.muammarahlnn.lsv.core.util.navigateRoute

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassNavigatorNavigation, 12/05/2024 00.01
 */
private const val CLASS_NAVIGATOR_ROUTE = "class_navigator"
const val CLASS_ID_ARG = "class_id"
val CLASS_NAVIGATOR_FULL_ROUTE = createRoute(
    CLASS_NAVIGATOR_ROUTE,
    CLASS_ID_ARG,
)

fun NavController.navigateToClassNavigator(
    classId: String,
) {
    navigate(
        route = navigateRoute(CLASS_NAVIGATOR_ROUTE, classId),
    ) {
        addSlidingAnim()
    }
}