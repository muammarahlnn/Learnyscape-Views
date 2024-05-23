package com.muammarahlnn.lsv.ui.classnavigator.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.CLASS_ID_ARG
import com.muammarahlnn.lsv.core.navigation.CLASS_NAVIGATOR_FULL_ROUTE
import com.muammarahlnn.lsv.ui.classnavigator.ClassNavigatorFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassNavigatorNavigation, 11/05/2024 23.59
 */
fun NavGraphBuilder.classNavigatorFragmentt() {
    fragment<ClassNavigatorFragment>(CLASS_NAVIGATOR_FULL_ROUTE) {
        label = "Class Navigator"
        argument(CLASS_ID_ARG) {
            type = NavType.StringType
        }
    }
}