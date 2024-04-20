package com.muammarahlnn.lsv.core.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestModel, 21/04/2024 03.49
 */
data class PendingRequestModel(
    val id: String,
    val classId: String,
    val className: String,
    val lecturers: List<String>,
)