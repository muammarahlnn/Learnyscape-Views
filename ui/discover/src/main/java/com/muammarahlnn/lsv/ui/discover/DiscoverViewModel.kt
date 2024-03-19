package com.muammarahlnn.lsv.ui.discover

import androidx.lifecycle.SavedStateHandle
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverViewModel, 19/03/2024 02.19
 */
@HiltViewModel
internal class DiscoverViewModel @Inject constructor(
    initialState: DiscoverState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<DiscoverState>(initialState, savedStateHandle)