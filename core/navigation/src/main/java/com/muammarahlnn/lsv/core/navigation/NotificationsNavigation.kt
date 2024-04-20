package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import com.muammarahlnn.lsv.core.util.addSlidingAnim

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsNavigation, 20/04/2024 16.32
 */
const val NOTIFICATIONS_ROUTE = "notifications"

fun NavController.navigateToNotifications() {
    navigate(NOTIFICATIONS_ROUTE) {
        launchSingleTop = true
        addSlidingAnim()
    }
}