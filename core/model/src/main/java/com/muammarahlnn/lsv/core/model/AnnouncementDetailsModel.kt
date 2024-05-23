package com.muammarahlnn.lsv.core.model

import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AnnouncementDetailsModel, 23/05/2024 14.15
 */
data class AnnouncementDetailsModel(
    val id: String,
    val authorName: String,
    val updatedAt: String,
    val description: String,
    val attachments: List<File>,
)