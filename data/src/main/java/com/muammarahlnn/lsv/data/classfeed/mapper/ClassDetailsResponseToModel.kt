package com.muammarahlnn.lsv.data.classfeed.mapper

import com.muammarahlnn.lsv.core.model.ClassDetailsModel
import com.muammarahlnn.lsv.core.model.DayModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toLocalTime
import com.muammarahlnn.lsv.data.discover.mapper.ClassMemberResponseToModel
import com.muammarahlnn.lsv.network.classfeed.response.ClassDetailsResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassDetailsResponseToModel, 21/05/2024 04.17
 */
class ClassDetailsResponseToModel @Inject constructor(
    private val classMemberResponseMapper: ClassMemberResponseToModel,
) :
    Mapper<ClassDetailsResponse, ClassDetailsModel> {

    override fun map(from: ClassDetailsResponse): ClassDetailsModel = ClassDetailsModel(
        id = from.id,
        name = from.name,
        day = DayModel.fromDayName(from.day.name),
        startTime = from.time.toLocalTime(),
        endTime = from.endTime.toLocalTime(),
        lecturers = from.lecturers.map(classMemberResponseMapper::map),
    )
}