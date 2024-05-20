package com.muammarahlnn.lsv.data.classoverview.mapper

import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.formatEpochSeconds
import com.muammarahlnn.lsv.network.classoverview.response.TaskOverviewResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File TaskOverviewResponseToModel, 20/05/2024 00.09
 */
class TaskOverviewResponseToModel @Inject constructor() :
    Mapper<TaskOverviewResponse, ClassResourceOverviewModel> {

    override fun map(from: TaskOverviewResponse): ClassResourceOverviewModel = ClassResourceOverviewModel(
        id = from.id,
        name = from.name,
        date = formatEpochSeconds(from.dueDate),
    )
}