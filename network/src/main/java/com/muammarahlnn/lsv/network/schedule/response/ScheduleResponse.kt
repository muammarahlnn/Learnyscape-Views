package com.muammarahlnn.lsv.network.schedule.response

import com.muammarahlnn.lsv.network.discover.response.DayResponse
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleResponse, 06/05/2024 14.18
 */
@Serializable
data class ScheduleResponse(
    val id: String,
    val className: String,
    val startTime: Int,
    val endTime: Int,
    val day: DayResponse,
)