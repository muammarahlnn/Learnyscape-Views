package com.muammarahlnn.lsv.ui.classmember

import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberViewModel, 12/05/2024 02.47
 */
@HiltViewModel
internal class ClassMemberViewModel @Inject constructor(
    initialState: ClassMemberState,
) : BaseViewModel<ClassMemberState>(initialState)