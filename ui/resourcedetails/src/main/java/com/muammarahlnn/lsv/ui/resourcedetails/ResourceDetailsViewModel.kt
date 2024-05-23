package com.muammarahlnn.lsv.ui.resourcedetails

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.ANNOUNCEMENT
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.ASSIGNMENT
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.MODULE
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.QUIZ
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.resourcedetails.GetAnnouncementDetailsUseCase
import com.muammarahlnn.lsv.domain.resourcedetails.GetAssignmentDetailsUseCase
import com.muammarahlnn.lsv.domain.resourcedetails.GetModuleDetailsUseCase
import com.muammarahlnn.lsv.domain.resourcedetails.GetQuizDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsViewModel, 22/05/2024 21.07
 */
@HiltViewModel
internal class ResourceDetailsViewModel @Inject constructor(
    private val getAnnouncementDetailsUseCase: GetAnnouncementDetailsUseCase,
    private val getModuleDetailsUseCase: GetModuleDetailsUseCase,
    private val getAssignmentDetailsUseCase: GetAssignmentDetailsUseCase,
    private val getQuizDetailsUseCase: GetQuizDetailsUseCase,
    initialState: ResourceDetailsUiState,
) : BaseViewModel<ResourceDetailsUiState>(initialState) {

    lateinit var resourceId: String

    lateinit var classResourceType: ClassResourceTypeModel

    fun fetchResourceDetails() {
        when (classResourceType) {
            ANNOUNCEMENT -> fetchAnnouncementDetails()
            MODULE -> fetchModuleDetails()
            ASSIGNMENT -> fetchAssignmentDetails()
            QUIZ -> fetchQuizDetails()
        }
    }

    private fun fetchAnnouncementDetails() {
        getAnnouncementDetailsUseCase.execute(
            params = GetAnnouncementDetailsUseCase.Params(
                announcementId = resourceId,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ResourceDetailsUiState.LoadingFetchDetails(true) }
            },
            onSuccess = { announcementDetails ->
                updateState {
                    ResourceDetailsUiState.SuccessFetchDetails(
                        ResourceDetailsState(
                            resourceType = classResourceType,
                            name = announcementDetails.authorName,
                            date = announcementDetails.updatedAt,
                            description = announcementDetails.description,
                            attachments = announcementDetails.attachments,
                        )
                    )
                }
            },
            onError = { throwable ->
                updateState { ResourceDetailsUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ResourceDetailsUiState.LoadingFetchDetails(false) }
            },
        )
    }

    private fun fetchModuleDetails() {
        getModuleDetailsUseCase.execute(
            params = GetModuleDetailsUseCase.Params(
                moduleId = resourceId,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ResourceDetailsUiState.LoadingFetchDetails(true) }
            },
            onSuccess = { moduleDetails ->
                updateState {
                    ResourceDetailsUiState.SuccessFetchDetails(
                        ResourceDetailsState(
                            resourceType = classResourceType,
                            name = moduleDetails.name,
                            date = moduleDetails.updatedAt,
                            description = moduleDetails.description,
                            attachments = moduleDetails.attachments,
                        )
                    )
                }
            },
            onError = { throwable ->
                updateState { ResourceDetailsUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ResourceDetailsUiState.LoadingFetchDetails(false) }
            },
        )
    }

    private fun fetchAssignmentDetails() {
        getAssignmentDetailsUseCase.execute(
            params = GetAssignmentDetailsUseCase.Params(
                assignmentId = resourceId,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ResourceDetailsUiState.LoadingFetchDetails(true) }
            },
            onSuccess = { assignmentDetails ->
                updateState {
                    ResourceDetailsUiState.SuccessFetchDetails(
                        ResourceDetailsState(
                            resourceType = classResourceType,
                            name = assignmentDetails.name,
                            date = assignmentDetails.updatedAt,
                            description = assignmentDetails.description,
                            attachments = assignmentDetails.attachments,
                        )
                    )
                }
            },
            onError = { throwable ->
                updateState { ResourceDetailsUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ResourceDetailsUiState.LoadingFetchDetails(false) }
            },
        )
    }

    private fun fetchQuizDetails() {
        getQuizDetailsUseCase.execute(
            params = GetQuizDetailsUseCase.Params(
                quizId = resourceId,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ResourceDetailsUiState.LoadingFetchDetails(true) }
            },
            onSuccess = { quizDetails ->
                updateState {
                    ResourceDetailsUiState.SuccessFetchDetails(
                        ResourceDetailsState(
                            resourceType = classResourceType,
                            name = quizDetails.name,
                            date = quizDetails.updatedAt,
                            description = quizDetails.description,
                            startQuizDate = quizDetails.startDate,
                            endQuizDate = quizDetails.endDate,
                            quizDuration = quizDetails.duration,
                            quizType = quizDetails.quizType,
                        )
                    )
                }
            },
            onError = { throwable ->
                updateState { ResourceDetailsUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ResourceDetailsUiState.LoadingFetchDetails(false) }
            },
        )
    }
}