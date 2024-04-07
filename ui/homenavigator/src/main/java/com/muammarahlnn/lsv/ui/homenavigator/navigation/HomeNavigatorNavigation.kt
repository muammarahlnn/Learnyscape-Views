package com.muammarahlnn.lsv.ui.homenavigator.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.ui.homenavigator.HomeNavigatorFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigatorNavigation, 19/03/2024 03.56
 */
const val HOME_NAVIGATOR_ROUTE = "home_navigator"

fun NavGraphBuilder.homeNavigatorFragment() {
    fragment<HomeNavigatorFragment>(HOME_NAVIGATOR_ROUTE) {
        label = "Home Navigator"
    }
}