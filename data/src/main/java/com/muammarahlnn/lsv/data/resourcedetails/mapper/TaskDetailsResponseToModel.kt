package com.muammarahlnn.lsv.data.resourcedetails.mapper

import com.muammarahlnn.lsv.core.model.AssignmentDetailsModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.formatEpochSeconds
import com.muammarahlnn.lsv.data.base.toStringDateFormatted
import com.muammarahlnn.lsv.network.resourcedetails.response.TaskDetailsResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File TaskDetailsResponseToModel, 23/05/2024 14.40
 */
class TaskDetailsResponseToModel @Inject constructor() :
    Mapper<TaskDetailsResponse, AssignmentDetailsModel> {

    override fun map(from: TaskDetailsResponse): AssignmentDetailsModel = AssignmentDetailsModel(
        id = from.id,
        name = from.name,
        description = from.description.orEmpty(),
        updatedAt = from.updatedAt.toStringDateFormatted(),
        dueDate = formatEpochSeconds(from.dueDate),
        attachments = emptyList(),
    )
}