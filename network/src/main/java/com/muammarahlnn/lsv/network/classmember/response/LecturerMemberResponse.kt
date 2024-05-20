package com.muammarahlnn.lsv.network.classmember.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LecturerMemberResponse, 20/05/2024 20.34
 */
@Serializable
data class LecturerMemberResponse(
    val lecturerId: String,
    val name: String,
    @SerialName("profileURI") val profileUri:String,
)