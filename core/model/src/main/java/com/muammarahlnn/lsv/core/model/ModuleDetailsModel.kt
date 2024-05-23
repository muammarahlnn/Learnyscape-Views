package com.muammarahlnn.lsv.core.model

import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ModuleDetailsModel, 23/05/2024 14.15
 */
data class ModuleDetailsModel(
    val id: String,
    val name: String,
    val description: String,
    val updatedAt: String,
    val attachments: List<File>,
)