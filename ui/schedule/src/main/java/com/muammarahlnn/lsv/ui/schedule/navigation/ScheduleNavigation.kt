package com.muammarahlnn.lsv.ui.schedule.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.SCHEDULE_ROUTE
import com.muammarahlnn.lsv.ui.schedule.ScheduleFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleNavigation, 19/03/2024 03.54
 */
fun NavGraphBuilder.scheduleFragment() {
    fragment<ScheduleFragment>(SCHEDULE_ROUTE) {
        label = "Schedule"
    }
}