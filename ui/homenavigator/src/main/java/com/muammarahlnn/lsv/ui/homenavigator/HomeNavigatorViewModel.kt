package com.muammarahlnn.lsv.ui.homenavigator

import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigatorViewModel, 19/03/2024 03.25
 */
@HiltViewModel
internal class HomeNavigatorViewModel @Inject constructor(
    initialState: HomeNavigatorState,
) : BaseViewModel<HomeNavigatorState>(initialState)