package com.muammarahlnn.lsv.network.classfeed.response

import com.muammarahlnn.lsv.network.discover.response.ClassMemberResponse
import com.muammarahlnn.lsv.network.discover.response.DayResponse
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassDetailsResponse, 21/05/2024 04.07
 */
@Serializable
data class ClassDetailsResponse(
    val id: String,
    val name: String,
    val day: DayResponse,
    val time: Int,
    val endTime: Int,
    val lecturers: List<ClassMemberResponse>,
)