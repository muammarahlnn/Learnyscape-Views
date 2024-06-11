package com.muammarahlnn.lsv.data.assignmentsubmission.mapper

import com.muammarahlnn.lsv.core.model.AssignmentSubmissionModel
import com.muammarahlnn.lsv.data.base.Mapper
import com.muammarahlnn.lsv.data.base.toStringDateFormatted
import com.muammarahlnn.lsv.network.assignmentsubmission.response.StudentTaskSubmissionResponse
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File StudentTaskSubmissionResponseToModel, 10/06/2024 15.26
 */
class StudentTaskSubmissionResponseToModel @Inject constructor() :
    Mapper<StudentTaskSubmissionResponse, AssignmentSubmissionModel> {

    override fun map(from: StudentTaskSubmissionResponse): AssignmentSubmissionModel = AssignmentSubmissionModel(
        assignmentSubmissionId = from.taskSubmissionId,
        userId = from.userId,
        studentName = from.studentName,
        turnInStatus = from.turnInStatus,
        turnedInAt = from.turnedInAt?.toStringDateFormatted().orEmpty(),
    )
}