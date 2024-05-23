package com.muammarahlnn.lsv.data.resourcedetails.mapper

import com.muammarahlnn.lsv.core.model.ModuleDetailsModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toStringDateFormatted
import com.muammarahlnn.lsv.network.resourcedetails.response.ReferenceDetailsResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ReferenceDetailsResponseToModel, 23/05/2024 14.39
 */
class ReferenceDetailsResponseToModel @Inject constructor() :
    Mapper<ReferenceDetailsResponse, ModuleDetailsModel> {

    override fun map(from: ReferenceDetailsResponse): ModuleDetailsModel = ModuleDetailsModel(
        id = from.id,
        name = from.name,
        description = from.description.orEmpty(),
        updatedAt = from.updatedAt.toStringDateFormatted(),
        attachments = emptyList(),
    )
}