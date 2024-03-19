package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverNavigation, 19/03/2024 14.04
 */
private const val DISCOVER_ROUTE = "discover"

fun NavController.navigateToDiscover() {
    navigate(DISCOVER_ROUTE)
}