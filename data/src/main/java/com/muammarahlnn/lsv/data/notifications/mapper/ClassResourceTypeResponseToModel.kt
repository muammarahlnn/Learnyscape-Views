package com.muammarahlnn.lsv.data.notifications.mapper

import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.network.classfeed.response.ClassResourceTypeResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassResourceTypeResponseToModel, 20/04/2024 18.12
 */
class ClassResourceTypeResponseToModel @Inject constructor() : Mapper<ClassResourceTypeResponse, ClassResourceTypeModel> {

    override fun map(from: ClassResourceTypeResponse): ClassResourceTypeModel = when (from) {
        ClassResourceTypeResponse.ANNOUNCEMENT -> ClassResourceTypeModel.ANNOUNCEMENT
        ClassResourceTypeResponse.REFERENCE -> ClassResourceTypeModel.MODULE
        ClassResourceTypeResponse.TASK -> ClassResourceTypeModel.ASSIGNMENT
        ClassResourceTypeResponse.QUIZ -> ClassResourceTypeModel.QUIZ
    }
}