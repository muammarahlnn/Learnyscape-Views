package com.muammarahlnn.lsv.data.home.mapper

import com.muammarahlnn.lsv.core.model.EnrolledClassModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.network.home.response.EnrolledClassResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File EnrolledClassResponseToModel, 09/04/2024 03.50
 */
class EnrolledClassResponseToModel @Inject constructor() : Mapper<EnrolledClassResponse, EnrolledClassModel> {

    override fun map(from: EnrolledClassResponse): EnrolledClassModel = EnrolledClassModel(
        id = from.id,
        className = from.className,
        lecturerNames = from.lecturerNames,
    )
}