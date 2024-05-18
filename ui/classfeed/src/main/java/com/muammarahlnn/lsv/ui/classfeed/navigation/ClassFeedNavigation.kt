package com.muammarahlnn.lsv.ui.classfeed.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.CLASS_FEED_FULL_ROUTE
import com.muammarahlnn.lsv.ui.classfeed.ClassFeedFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedNavigation, 12/05/2024 02.38
 */
fun NavGraphBuilder.classFeedFragment() {
    fragment<ClassFeedFragment>(CLASS_FEED_FULL_ROUTE) {
        label = "Class Feed"
    }
}