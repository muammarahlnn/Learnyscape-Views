package com.muammarahlnn.lsv.network.schedule

import com.muammarahlnn.lsv.network.schedule.response.ScheduleResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleNetworkResponse, 06/05/2024 14.19
 */
@Singleton
class ScheduleNetworkResponse @Inject constructor(
    private val scheduleApi: ScheduleApi,
) {

    fun getSchedules(): Flow<List<ScheduleResponse>> = flow {
        emit(scheduleApi.getSchedules().data)
    }
}