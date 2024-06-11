package com.muammarahlnn.lsv.data.assignmentsubmission

import com.muammarahlnn.lsv.core.model.AssignmentSubmissionModel
import com.muammarahlnn.lsv.data.assignmentsubmission.mapper.StudentTaskSubmissionResponseToModel
import com.muammarahlnn.lsv.network.assignmentsubmission.AssignmentSubmissionNetworkDataSource
import com.muammarahlnn.lsv.network.attachment.AttachmentNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionRepository, 10/06/2024 15.22
 */
class AssignmentSubmissionRepository @Inject constructor(
    private val assignmentSubmissionNetworkDataSource: AssignmentSubmissionNetworkDataSource,
    private val attachmentNetworkDataSource: AttachmentNetworkDataSource,
    private val studentTaskSubmissionMapper: StudentTaskSubmissionResponseToModel,
) {

    fun studentGetAssignmentSubmission(assignmentId: String): Flow<AssignmentSubmissionModel> =
        assignmentSubmissionNetworkDataSource.studentGetTaskSubmission(assignmentId)
            .flatMapLatest { studentTaskSubmissionResponse ->
                attachmentNetworkDataSource.getAttachments(studentTaskSubmissionResponse.attachmentUrls)
                    .map { attachments ->
                        studentTaskSubmissionMapper.map(studentTaskSubmissionResponse).copy(
                            attachments = attachments.filterNotNull()
                        )
                    }
            }
}