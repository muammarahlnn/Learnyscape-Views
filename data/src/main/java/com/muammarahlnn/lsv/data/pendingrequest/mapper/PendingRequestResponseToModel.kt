package com.muammarahlnn.lsv.data.pendingrequest.mapper

import com.muammarahlnn.lsv.core.model.PendingRequestModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.network.pendingrequest.response.PendingRequestResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestResponseToModel, 21/04/2024 03.52
 */
class PendingRequestResponseToModel @Inject constructor() : Mapper<PendingRequestResponse, PendingRequestModel> {

    override fun map(from: PendingRequestResponse): PendingRequestModel = PendingRequestModel(
        id = from.id,
        classId = from.classId,
        className = from.className,
        lecturers = from.lecturers,
    )
}