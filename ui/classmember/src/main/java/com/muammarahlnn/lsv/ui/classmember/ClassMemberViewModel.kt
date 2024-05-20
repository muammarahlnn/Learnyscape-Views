package com.muammarahlnn.lsv.ui.classmember

import androidx.lifecycle.viewModelScope
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import com.muammarahlnn.lsv.domain.classmember.GetClassMembersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberViewModel, 12/05/2024 02.47
 */
@HiltViewModel
internal class ClassMemberViewModel @Inject constructor(
    private val getClassMembersUseCase: GetClassMembersUseCase,
    initialState: ClassMemberUiState,
) : BaseViewModel<ClassMemberUiState>(initialState) {

    fun fetchClassMembers(classId: String) {
        getClassMembersUseCase.execute(
            params = GetClassMembersUseCase.Params(
                classId = classId,
            ),
            coroutineScope = viewModelScope,
            onStart = {
                updateState { ClassMemberUiState.Loading(true) }
            },
            onSuccess = { classMembers ->
                updateState { ClassMemberUiState.Success(classMembers) }
            },
            onError = { throwable ->
                updateState { ClassMemberUiState.Error(throwable.message.toString()) }
            },
            onCompletion = {
                updateState { ClassMemberUiState.Loading(false) }
            },
        )
    }
}