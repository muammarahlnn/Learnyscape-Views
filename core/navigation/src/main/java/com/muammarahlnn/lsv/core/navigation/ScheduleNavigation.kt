package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleNavigation, 19/03/2024 14.05
 */
private const val SCHEDULE_ROUTE = "schedule"

fun NavController.navigateToSchedule() {
    navigate(SCHEDULE_ROUTE)
}