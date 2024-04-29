package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import com.muammarahlnn.lsv.core.util.addSlidingAnim

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordNavigation, 29/04/2024 20.02
 */
const val CHANGE_PASSWORD_ROUTE = "change_password"

fun NavController.navigateToChangePassword() {
    navigate(CHANGE_PASSWORD_ROUTE) {
        launchSingleTop = true
        addSlidingAnim()
    }
}