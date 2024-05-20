package com.muammarahlnn.lsv.ui.classoverview

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.ASSIGNMENT
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.MODULE
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.QUIZ
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.classoverview.GetAssignmentsUseCase
import com.muammarahlnn.lsv.domain.classoverview.GetClassResourceOverviewsUseCase
import com.muammarahlnn.lsv.domain.classoverview.GetModulesUseCase
import com.muammarahlnn.lsv.domain.classoverview.GetQuizzesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewViewModel, 12/05/2024 00.11
 */
@HiltViewModel
internal class ClassOverviewViewModel @Inject constructor(
    private val getModulesUseCase: GetModulesUseCase,
    private val getAssignmentsUseCase: GetAssignmentsUseCase,
    private val getQuizzesUseCase: GetQuizzesUseCase,
    private val getClassResourceOverviewsUseCase: GetClassResourceOverviewsUseCase,
    initialState: ClassOverviewUiState,
) : BaseViewModel<ClassOverviewUiState>(initialState) {

    lateinit var classOverviewScreen: ClassOverviewScreen

    fun fetchClassResourcesOverview(classId: String) {
        getClassResourceOverviewsUseCase.execute(
            params = GetClassResourceOverviewsUseCase.Params(
                classId = classId,
                resourceType = when (classOverviewScreen) {
                    MODULE -> GetClassResourceOverviewsUseCase.Params.ResourceType.MODULE
                    ASSIGNMENT -> GetClassResourceOverviewsUseCase.Params.ResourceType.ASSIGNMENT
                    QUIZ -> GetClassResourceOverviewsUseCase.Params.ResourceType.QUIZ
                }
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ClassOverviewUiState.Loading(true) }
            },
            onSuccess = { classResourceOverviews ->
                updateState { ClassOverviewUiState.Success(classResourceOverviews) }
            },
            onError = { throwable ->
                updateState { ClassOverviewUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ClassOverviewUiState.Loading(false) }
            }
        )
    }
}