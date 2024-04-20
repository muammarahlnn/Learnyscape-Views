package com.muammarahlnn.lsv.core.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationModel, 20/04/2024 18.04
 */
data class NotificationModel(
    val id: String,
    val createdAt: String,
    val type: ClassResourceTypeModel,
    val uri: String,
    val title: String,
    val description: String,
)