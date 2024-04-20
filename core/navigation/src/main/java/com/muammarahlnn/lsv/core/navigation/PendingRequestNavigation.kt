package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import com.muammarahlnn.lsv.core.util.addSlidingAnim

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestNavigation, 21/04/2024 03.05
 */
const val PENDING_REQUEST_ROUTE = "pending_request"

fun NavController.navigateToPendingRequest() {
    navigate(PENDING_REQUEST_ROUTE) {
        launchSingleTop = true
        addSlidingAnim()
    }
}