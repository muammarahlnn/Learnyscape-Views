package com.muammarahlnn.lsv.ui.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.ui.home.HomeFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigation, 19/03/2024 03.44
 */
const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeFragment() {
    fragment<HomeFragment>(HOME_ROUTE) {
        label = "Home"
    }
}