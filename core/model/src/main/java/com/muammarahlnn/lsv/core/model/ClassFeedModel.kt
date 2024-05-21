package com.muammarahlnn.lsv.core.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedModel, 21/05/2024 04.13
 */
data class ClassFeedModel(
    val id: String,
    val name: String,
    val createdAt: String,
    val type: ClassResourceTypeModel,
    val uri: String,
    val description: String,
    val profilePicUrl: String,
)