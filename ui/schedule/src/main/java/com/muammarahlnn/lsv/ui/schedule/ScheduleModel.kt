package com.muammarahlnn.lsv.ui.schedule

import kotlinx.datetime.LocalTime

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleModel, 05/05/2024 15.37
 */
data class ScheduleModel(
    val className: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
)