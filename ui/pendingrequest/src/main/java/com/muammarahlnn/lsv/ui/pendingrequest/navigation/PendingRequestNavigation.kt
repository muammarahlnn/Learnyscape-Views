package com.muammarahlnn.lsv.ui.pendingrequest.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.PENDING_REQUEST_ROUTE
import com.muammarahlnn.lsv.ui.pendingrequest.PendingRequestFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestNavigation, 21/04/2024 03.17
 */

fun NavGraphBuilder.pendingRequestFragment() {
    fragment<PendingRequestFragment>(PENDING_REQUEST_ROUTE) {
        label = "Pending Request"
    }
}