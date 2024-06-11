package com.muammarahlnn.lsv.network.assignmentsubmission.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File StudentTaskSubmissionResponse, 10/06/2024 15.20
 */
@Serializable
data class StudentTaskSubmissionResponse(
    val userId: String,
    val taskSubmissionId: String,
    val studentName: String,
    val turnInStatus: Boolean,
    val turnedInAt: String? = null,
    @SerialName("attachment") val attachmentUrls: List<String>,
)