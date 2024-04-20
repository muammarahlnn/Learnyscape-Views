package com.muammarahlnn.lsv.ui.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.HOME_ROUTE
import com.muammarahlnn.lsv.ui.home.HomeFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigation, 19/03/2024 03.44
 */
fun NavGraphBuilder.homeFragment() {
    fragment<HomeFragment>(HOME_ROUTE) {
        label = "Home"
    }
}