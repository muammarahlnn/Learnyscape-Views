package com.muammarahlnn.ui.lsv.notifications.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.NOTIFICATIONS_ROUTE
import com.muammarahlnn.ui.lsv.notifications.NotificationsFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsNavigation, 20/04/2024 16.34
 */
fun NavGraphBuilder.notificationsFragment() {
    fragment<NotificationsFragment>(NOTIFICATIONS_ROUTE) {
        label = "notifications"
    }
}