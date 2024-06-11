package com.muammarahlnn.lsv.core.model

import java.io.File

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionModel, 10/06/2024 15.24
 */
data class AssignmentSubmissionModel(
    val assignmentSubmissionId: String = "",
    val userId: String = "",
    val studentName: String = "",
    val turnInStatus: Boolean = false,
    val turnedInAt: String = "",
    val attachments: List<File> = emptyList(),
)