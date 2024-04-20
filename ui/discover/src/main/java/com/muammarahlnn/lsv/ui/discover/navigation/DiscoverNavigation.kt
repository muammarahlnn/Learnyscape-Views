package com.muammarahlnn.lsv.ui.discover.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.DISCOVER_ROUTE
import com.muammarahlnn.lsv.ui.discover.DiscoverFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverNavigation, 19/03/2024 03.52
 */
fun NavGraphBuilder.discoverFragment() {
    fragment<DiscoverFragment>(DISCOVER_ROUTE) {
        label = "Discover"
    }
}