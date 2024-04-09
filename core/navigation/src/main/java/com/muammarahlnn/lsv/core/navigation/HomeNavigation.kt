package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigation, 19/03/2024 13.59
 */
private const val HOME_ROUTE = "home"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(HOME_ROUTE, navOptions)
}