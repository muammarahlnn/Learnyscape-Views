package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverNavigation, 19/03/2024 14.04
 */
private const val DISCOVER_ROUTE = "discover"

fun NavController.navigateToDiscover(navOptions: NavOptions? = null) {
    navigate(DISCOVER_ROUTE, navOptions)
}