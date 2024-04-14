package com.muammarahlnn.lsv.data.discover.mapper

import com.muammarahlnn.lsv.core.model.AvailableClassModel
import com.muammarahlnn.lsv.core.model.AvailableClassModel.RequestStatus
import com.muammarahlnn.lsv.core.model.DayModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toLocalTime
import com.muammarahlnn.lsv.network.discover.response.AvailableClassResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AvailableClassResponseToModel, 14/04/2024 13.39
 */
class AvailableClassResponseToModel @Inject constructor(
    private val classMemberResponseToModel: ClassMemberResponseToModel,
) : Mapper<AvailableClassResponse, AvailableClassModel> {

    fun List<AvailableClassResponse>.toModel(): List<AvailableClassModel> = map(::map)

    override fun map(from: AvailableClassResponse): AvailableClassModel = AvailableClassModel(
        id = from.id,
        name = from.name,
        day = DayModel.fromDayName(from.day.name),
        startTime = from.time.toLocalTime(),
        endTime = from.endTime.toLocalTime(),
        lecturers = from.lecturers.map(classMemberResponseToModel::map),
        students = from.students.map(classMemberResponseToModel::map),
        requestStatus = when (from.status) {
            AvailableClassResponse.Status.PENDING -> RequestStatus.PENDING
            else -> RequestStatus.UNREQUESTED
        }
    )
}