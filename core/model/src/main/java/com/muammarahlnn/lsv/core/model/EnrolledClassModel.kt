package com.muammarahlnn.lsv.core.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File EnrolledClassModel, 09/04/2024 03.49
 */
data class EnrolledClassModel(
    val id: String,
    val className: String,
    val lecturerNames: List<String>,
)