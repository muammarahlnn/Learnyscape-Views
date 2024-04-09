package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleNavigation, 19/03/2024 14.05
 */
private const val SCHEDULE_ROUTE = "schedule"

fun NavController.navigateToSchedule(navOptions: NavOptions? = null) {
    navigate(SCHEDULE_ROUTE, navOptions)
}