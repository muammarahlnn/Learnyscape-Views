@file:Suppress("UNCHECKED_CAST")

package com.muammarahlnn.lsv.core.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseViewModel, 15/03/2024 16.36
 */
abstract class BaseViewModel<S>(
    initialState: S,
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)

    val state: Flow<S>
        get() = _state.asStateFlow()

    protected val stateValue: S
        get() = _state.value

    protected fun updateState(reducer: S.() -> S) {
        _state.update(reducer)
    }
}