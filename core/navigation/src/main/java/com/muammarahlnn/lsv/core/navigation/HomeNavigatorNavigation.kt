package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import com.muammarahlnn.lsv.core.util.addSlidingAnim

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigatorNavigation, 19/03/2024 04.58
 */
const val HOME_NAVIGATOR_ROUTE = "home_navigator"

fun NavController.navigateToHomeNavigator() {
    navigate(
        route = HOME_NAVIGATOR_ROUTE,
    ) {
        popUpTo(LOGIN_ROUTE) {
            inclusive = true
        }

        addSlidingAnim()
    }
}