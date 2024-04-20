package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileNavigation, 19/03/2024 14.06
 */
const val PROFILE_ROUTE = "profile"

fun NavController.navigateToProfile(navOptions: NavOptions? = null) {
    navigate(PROFILE_ROUTE, navOptions)
}