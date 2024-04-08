package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import com.muammarahlnn.lsv.core.util.addSlidingAnim

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginNavigation, 19/03/2024 04.57
 */
const val LOGIN_ROUTE = "login"

fun NavController.navigateToLogin() {
    navigate(LOGIN_ROUTE) {
        popUpTo(HOME_NAVIGATOR_ROUTE) {
            inclusive = true
        }

        addSlidingAnim()
    }
}