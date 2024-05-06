package com.muammarahlnn.lsv.core.model

import kotlinx.datetime.LocalTime

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleModel, 06/05/2024 14.29
 */
data class ScheduleModel(
    val id: String,
    val className: String,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val day: DayModel,
)