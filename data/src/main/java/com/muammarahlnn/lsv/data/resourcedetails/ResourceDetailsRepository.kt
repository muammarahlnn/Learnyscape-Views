package com.muammarahlnn.lsv.data.resourcedetails

import com.muammarahlnn.lsv.core.model.AnnouncementDetailsModel
import com.muammarahlnn.lsv.core.model.AssignmentDetailsModel
import com.muammarahlnn.lsv.core.model.ModuleDetailsModel
import com.muammarahlnn.lsv.core.model.QuizDetailsModel
import com.muammarahlnn.lsv.data.resourcedetails.mapper.AnnouncementDetailsResponseToModel
import com.muammarahlnn.lsv.data.resourcedetails.mapper.QuizDetailsResponseToModel
import com.muammarahlnn.lsv.data.resourcedetails.mapper.ReferenceDetailsResponseToModel
import com.muammarahlnn.lsv.data.resourcedetails.mapper.TaskDetailsResponseToModel
import com.muammarahlnn.lsv.network.attachment.AttachmentNetworkDataSource
import com.muammarahlnn.lsv.network.resourcedetails.ResourceDetailsNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import java.io.File
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsRepository, 23/05/2024 14.14
 */
class ResourceDetailsRepository @Inject constructor(
    private val resourceDetailsNetworkDataSource: ResourceDetailsNetworkDataSource,
    private val attachmentNetworkDataSource: AttachmentNetworkDataSource,
    private val announcementDetailsMapper: AnnouncementDetailsResponseToModel,
    private val moduleDetailsMapper: ReferenceDetailsResponseToModel,
    private val assignmentDetailsMapper: TaskDetailsResponseToModel,
    private val quizDetailsMapper: QuizDetailsResponseToModel,
) {

    fun getAnnouncementDetails(announcementId: String): Flow<AnnouncementDetailsModel> =
        resourceDetailsNetworkDataSource.getAnnouncementDetails(announcementId).flatMapLatest { announcementDetailsResponse ->
            getAttachments(announcementDetailsResponse.attachmentUrls).map { attachments ->
                announcementDetailsMapper.map(announcementDetailsResponse).copy(
                    attachments = attachments,
                )
            }
        }

    fun getModuleDetails(moduleId: String): Flow<ModuleDetailsModel> =
        resourceDetailsNetworkDataSource.getReferenceDetails(moduleId).flatMapLatest { referenceDetailsResponse ->
            getAttachments(referenceDetailsResponse.attachmentUrls).map { attachments ->
                moduleDetailsMapper.map(referenceDetailsResponse).copy(
                    attachments = attachments,
                )
            }
        }

    fun getAssignmentDetails(assignmentId: String): Flow<AssignmentDetailsModel> =
        resourceDetailsNetworkDataSource.getTaskDetails(assignmentId).flatMapLatest { assignmentDetailsResponse ->
            getAttachments(assignmentDetailsResponse.attachmentUrls).map { attachments ->
                assignmentDetailsMapper.map(assignmentDetailsResponse).copy(
                    attachments = attachments,
                )
            }
        }

    fun getQuizDetails(quizId: String): Flow<QuizDetailsModel> =
        resourceDetailsNetworkDataSource.getQuizDetails(quizId).map(quizDetailsMapper::map)

    private fun getAttachments(attachmentUrls: List<String>): Flow<List<File>> =
        attachmentNetworkDataSource.getAttachments(attachmentUrls).map { it.filterNotNull() }
}