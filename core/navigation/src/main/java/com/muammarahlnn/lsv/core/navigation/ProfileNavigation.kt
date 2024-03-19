package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileNavigation, 19/03/2024 14.06
 */
private const val PROFILE_ROUTE = "profile"

fun NavController.navigateToProfile() {
    navigate(PROFILE_ROUTE)
}