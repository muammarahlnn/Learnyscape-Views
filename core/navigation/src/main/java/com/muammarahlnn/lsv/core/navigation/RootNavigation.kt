package com.muammarahlnn.lsv.core.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File RootNavigation, 08/04/2024 07.29
 */

fun FragmentActivity.getRootNavController(): NavController {
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_root) as NavHostFragment
    return navHostFragment.navController
}