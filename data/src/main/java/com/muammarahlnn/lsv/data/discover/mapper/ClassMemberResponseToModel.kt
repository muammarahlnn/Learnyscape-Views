package com.muammarahlnn.lsv.data.discover.mapper

import com.muammarahlnn.lsv.core.model.ClassMemberModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.network.discover.response.ClassMemberResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberResponseToModel, 14/04/2024 13.41
 */
class ClassMemberResponseToModel @Inject constructor() : Mapper<ClassMemberResponse, ClassMemberModel> {

    override fun map(from: ClassMemberResponse): ClassMemberModel = ClassMemberModel(
        id = from.id,
        username = from.username,
        fullName = from.fullName,
    )
}