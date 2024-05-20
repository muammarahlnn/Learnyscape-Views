package com.muammarahlnn.lsv.data.classoverview.mapper

import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toStringDateFormatted
import com.muammarahlnn.lsv.network.classoverview.response.ReferenceOverviewResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ReferenceResponseToModel, 20/05/2024 00.01
 */
class ReferenceOverviewResponseToModel @Inject constructor() :
    Mapper<ReferenceOverviewResponse, ClassResourceOverviewModel> {

    override fun map(from: ReferenceOverviewResponse): ClassResourceOverviewModel = ClassResourceOverviewModel(
        id = from.id,
        name = from.name,
        date = from.updatedAt.toStringDateFormatted()
    )
}