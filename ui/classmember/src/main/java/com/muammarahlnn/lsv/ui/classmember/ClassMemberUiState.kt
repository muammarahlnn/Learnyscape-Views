package com.muammarahlnn.lsv.ui.classmember

import com.muammarahlnn.lsv.core.model.ClassMembersModel

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberState, 12/05/2024 02.47
 */
internal sealed interface ClassMemberUiState {

    data class Loading(val loading: Boolean) : ClassMemberUiState

    data class Success(val classMembers: ClassMembersModel) : ClassMemberUiState

    data class Error(val message: String) : ClassMemberUiState
}