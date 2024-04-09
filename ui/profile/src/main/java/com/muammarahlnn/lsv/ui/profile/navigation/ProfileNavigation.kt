package com.muammarahlnn.lsv.ui.profile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.ui.profile.ProfileFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileNavigation, 19/03/2024 03.53
 */
const val PROFILE_ROUTE = "profile"

fun NavGraphBuilder.profileFragment() {
    fragment<ProfileFragment>(PROFILE_ROUTE) {
        label = "Profile"
    }
}