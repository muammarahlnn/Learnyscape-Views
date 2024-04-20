package com.muammarahlnn.lsv.data.notifications.mapper

import com.muammarahlnn.lsv.core.model.NotificationModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toStringDateFormatted
import com.muammarahlnn.lsv.network.notifications.response.NotificationResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationResponseToModel, 20/04/2024 18.06
 */
class NotificationResponseToModel @Inject constructor(
    private val classResourceTypeResponseToModel: ClassResourceTypeResponseToModel,
) : Mapper<NotificationResponse, NotificationModel> {

    override fun map(from: NotificationResponse): NotificationModel = NotificationModel(
        id = from.id,
        createdAt = from.createdAt.toStringDateFormatted(),
        type = classResourceTypeResponseToModel.map(from.type),
        uri = from.uri,
        description = from.description,
        title = from.title,
    )
}