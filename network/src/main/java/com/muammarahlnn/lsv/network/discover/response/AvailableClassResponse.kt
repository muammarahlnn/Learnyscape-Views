package com.muammarahlnn.lsv.network.discover.response

import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AvailableClassResponse, 13/04/2024 13.24
 */
@Serializable
data class AvailableClassResponse(
    val id: String,
    val name: String,
    val day: DayResponse,
    val time: Int,
    val endTime: Int,
    val lecturers: List<ClassMemberResponse>,
    val students: List<ClassMemberResponse>,
    val status: Status? = null,
) {

    enum class Status {
        PENDING,
    }
}