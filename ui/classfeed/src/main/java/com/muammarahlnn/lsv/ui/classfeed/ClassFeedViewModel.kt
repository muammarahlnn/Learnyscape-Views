package com.muammarahlnn.lsv.ui.classfeed

import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedViewModel, 12/05/2024 02.38
 */
@HiltViewModel
internal class ClassFeedViewModel @Inject constructor(
    initialState: ClassFeedState,
) : BaseViewModel<ClassFeedState>(initialState)