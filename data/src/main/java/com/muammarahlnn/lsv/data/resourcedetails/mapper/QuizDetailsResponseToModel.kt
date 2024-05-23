package com.muammarahlnn.lsv.data.resourcedetails.mapper

import com.muammarahlnn.lsv.core.model.QuizDetailsModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.formatEpochSeconds
import com.muammarahlnn.lsv.data.base.toStringDateFormatted
import com.muammarahlnn.lsv.network.resourcedetails.response.QuizDetailsResponse
import com.muammarahlnn.lsv.network.resourcedetails.response.QuizDetailsResponse.QuizType.MULTIPLE_CHOICE
import com.muammarahlnn.lsv.network.resourcedetails.response.QuizDetailsResponse.QuizType.PHOTO_ANSWER
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File QuizDetailsResponseToModel, 23/05/2024 14.42
 */
class QuizDetailsResponseToModel @Inject constructor() :
    Mapper<QuizDetailsResponse, QuizDetailsModel> {

    override fun map(from: QuizDetailsResponse): QuizDetailsModel = QuizDetailsModel(
        id = from.id,
        name = from.name,
        updatedAt = from.updatedAt.toStringDateFormatted(),
        description = from.description.orEmpty(),
        startDate = formatEpochSeconds(from.startDate),
        endDate = formatEpochSeconds(from.endDate),
        duration = from.duration,
        quizType = when (from.type) {
            MULTIPLE_CHOICE -> QuizDetailsModel.QuizType.MULTIPLE_CHOICE
            PHOTO_ANSWER -> QuizDetailsModel.QuizType.PHOTO_ANSWER
        }
    )
}