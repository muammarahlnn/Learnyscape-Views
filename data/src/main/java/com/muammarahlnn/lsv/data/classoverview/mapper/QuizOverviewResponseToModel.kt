package com.muammarahlnn.lsv.data.classoverview.mapper

import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.formatEpochSeconds
import com.muammarahlnn.lsv.network.classoverview.response.QuizOverviewResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File QuizOverviewResponseToMOdel, 20/05/2024 00.10
 */
class QuizOverviewResponseToModel @Inject constructor() :
    Mapper<QuizOverviewResponse, ClassResourceOverviewModel> {

    override fun map(from: QuizOverviewResponse): ClassResourceOverviewModel = ClassResourceOverviewModel(
        id = from.id,
        name = from.name,
        date = formatEpochSeconds(from.startDate),
    )
}