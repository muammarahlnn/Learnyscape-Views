package com.muammarahlnn.lsv.network.schedule

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.schedule.response.ScheduleResponse
import retrofit2.http.GET

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleApi, 06/05/2024 14.17
 */
interface ScheduleApi {

    @GET("users/schedules")
    suspend fun getSchedules(): BaseResponse<List<ScheduleResponse>>
}