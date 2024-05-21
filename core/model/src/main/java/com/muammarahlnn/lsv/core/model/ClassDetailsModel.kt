package com.muammarahlnn.lsv.core.model

import kotlinx.datetime.LocalTime

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassDetailsModel, 21/05/2024 04.11
 */
data class ClassDetailsModel(
    val id: String,
    val name: String,
    val day: DayModel,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val lecturers: List<ClassMemberModel>,
)