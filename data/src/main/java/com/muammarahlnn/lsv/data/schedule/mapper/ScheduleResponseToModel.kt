package com.muammarahlnn.lsv.data.schedule.mapper

import com.muammarahlnn.lsv.core.model.DayModel
import com.muammarahlnn.lsv.core.model.ScheduleModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toLocalTime
import com.muammarahlnn.lsv.network.schedule.response.ScheduleResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleResponseToModel, 06/05/2024 14.31
 */
class ScheduleResponseToModel @Inject constructor() : Mapper<ScheduleResponse, ScheduleModel> {

    override fun map(from: ScheduleResponse): ScheduleModel = ScheduleModel(
        id = from.id,
        className = from.className,
        startTime = from.startTime.toLocalTime(),
        endTime = from.endTime.toLocalTime(),
        day = DayModel.fromDayName(from.day.name)
    )
}