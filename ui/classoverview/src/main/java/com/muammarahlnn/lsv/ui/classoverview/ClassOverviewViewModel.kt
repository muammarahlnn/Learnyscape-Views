package com.muammarahlnn.lsv.ui.classoverview

import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewViewModel, 12/05/2024 00.11
 */
@HiltViewModel
internal class ClassOverviewViewModel @Inject constructor(
    initialState: ClassOverviewState,
) : BaseViewModel<ClassOverviewState>(initialState)