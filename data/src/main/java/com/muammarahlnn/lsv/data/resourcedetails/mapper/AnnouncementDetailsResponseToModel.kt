package com.muammarahlnn.lsv.data.resourcedetails.mapper

import com.muammarahlnn.lsv.core.model.AnnouncementDetailsModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toStringDateFormatted
import com.muammarahlnn.lsv.network.resourcedetails.response.AnnouncementDetailsResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AnnouncementDetailsResponseToModel, 23/05/2024 14.29
 */
class AnnouncementDetailsResponseToModel @Inject constructor() :
    Mapper<AnnouncementDetailsResponse, AnnouncementDetailsModel> {

    override fun map(from: AnnouncementDetailsResponse): AnnouncementDetailsModel = AnnouncementDetailsModel(
        id = from.id,
        authorName = from.authorName,
        updatedAt = from.updatedAt.toStringDateFormatted(),
        description = from.description.orEmpty(),
        attachments = emptyList(),
    )
}