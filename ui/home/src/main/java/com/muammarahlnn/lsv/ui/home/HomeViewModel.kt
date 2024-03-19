package com.muammarahlnn.lsv.ui.home

import androidx.lifecycle.SavedStateHandle
import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeViewModel, 19/03/2024 02.35
 */
@HiltViewModel
internal class HomeViewModel @Inject constructor(
    initialState: HomeState,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<HomeState>(initialState, savedStateHandle)