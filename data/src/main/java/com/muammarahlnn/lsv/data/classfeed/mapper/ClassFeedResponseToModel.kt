package com.muammarahlnn.lsv.data.classfeed.mapper

import com.muammarahlnn.lsv.core.model.ClassFeedModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toStringDateFormatted
import com.muammarahlnn.lsv.data.notifications.mapper.ClassResourceTypeResponseToModel
import com.muammarahlnn.lsv.network.classfeed.response.ClassFeedResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedResponseToModel, 21/05/2024 04.20
 */
class ClassFeedResponseToModel @Inject constructor(
    private val classResourceTypeResponseMapper: ClassResourceTypeResponseToModel,
) : Mapper<ClassFeedResponse, ClassFeedModel> {

    override fun map(from: ClassFeedResponse): ClassFeedModel = ClassFeedModel(
        id = from.id,
        name = from.name.orEmpty(),
        createdAt = from.createdAt.toStringDateFormatted(),
        type = classResourceTypeResponseMapper.map(from.type),
        uri = from.uri,
        description = from.description.orEmpty(),
        profilePicUrl = from.profilePicUrl.orEmpty(),
    )
}