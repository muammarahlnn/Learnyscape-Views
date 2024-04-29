package com.muammarahlnn.lsv.ui.changepassword.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.CHANGE_PASSWORD_ROUTE
import com.muammarahlnn.lsv.ui.changepassword.ChangePasswordFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordNavigation, 29/04/2024 20.01
 */
fun NavGraphBuilder.changePasswordFragment() {
    fragment<ChangePasswordFragment>(CHANGE_PASSWORD_ROUTE) {
        label = "Change Password"
    }
}