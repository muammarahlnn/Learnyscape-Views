package com.muammarahlnn.lsv.data.schedule

import com.muammarahlnn.lsv.core.model.ScheduleModel
import com.muammarahlnn.lsv.data.schedule.mapper.ScheduleResponseToModel
import com.muammarahlnn.lsv.network.schedule.ScheduleNetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleRepository, 06/05/2024 14.29
 */
class ScheduleRepository @Inject constructor(
    private val scheduleNetworkResponse: ScheduleNetworkResponse,
    private val scheduleResponseToModel: ScheduleResponseToModel,
) {

    fun getSchedules(): Flow<List<ScheduleModel>> = scheduleNetworkResponse.getSchedules().map { scheduleResponses ->
        scheduleResponses.map(scheduleResponseToModel::map)
    }
}