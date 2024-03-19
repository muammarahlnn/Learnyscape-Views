package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginNavigation, 19/03/2024 04.57
 */
const val LOGIN_ROUTE = "login"

fun NavController.navigateToLogin() {
    navigate(LOGIN_ROUTE)
}