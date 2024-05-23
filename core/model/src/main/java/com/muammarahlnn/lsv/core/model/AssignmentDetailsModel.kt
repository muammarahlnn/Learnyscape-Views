package com.muammarahlnn.lsv.core.model

import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentDetailsModel, 23/05/2024 14.15
 */
data class AssignmentDetailsModel(
    val id: String,
    val name: String,
    val description: String,
    val updatedAt: String,
    val dueDate: String,
    val attachments: List<File>,
)