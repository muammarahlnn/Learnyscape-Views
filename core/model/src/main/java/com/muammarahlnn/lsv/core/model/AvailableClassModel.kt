package com.muammarahlnn.lsv.core.model

import kotlinx.datetime.LocalTime

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AvailableClassModel, 14/04/2024 13.33
 */
data class AvailableClassModel(
    val id: String,
    val name: String,
    val day: DayModel,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val lecturers: List<ClassMemberModel>,
    val students: List<ClassMemberModel>,
    val requestStatus: RequestStatus,
) {

    fun isRequested(): Boolean = requestStatus == RequestStatus.PENDING

    enum class RequestStatus {
        UNREQUESTED, PENDING, ACCEPTED,
    }
}