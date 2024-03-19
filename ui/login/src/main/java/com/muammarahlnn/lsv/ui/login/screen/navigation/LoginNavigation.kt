package com.muammarahlnn.lsv.ui.login.screen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.ui.login.screen.LoginFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginNavigation, 19/03/2024 03.57
 */
const val LOGIN_ROUTE = "login"

fun NavGraphBuilder.loginFragment() {
    fragment<LoginFragment>(LOGIN_ROUTE) {
        label = "Login"
    }
}