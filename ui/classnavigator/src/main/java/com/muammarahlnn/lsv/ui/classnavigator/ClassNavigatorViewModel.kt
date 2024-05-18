package com.muammarahlnn.lsv.ui.classnavigator

import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassNavigatorViewModel, 11/05/2024 20.07
 */
@HiltViewModel
internal class ClassNavigatorViewModel @Inject constructor(
    initialState: ClassNavigatorState,
) : BaseViewModel<ClassNavigatorState>(initialState)