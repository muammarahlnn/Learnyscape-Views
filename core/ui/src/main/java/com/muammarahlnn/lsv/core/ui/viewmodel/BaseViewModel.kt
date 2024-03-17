@file:Suppress("UNCHECKED_CAST")

package com.muammarahlnn.lsv.core.ui.viewmodel

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
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
    protected val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val key: String
        get() = javaClass.name

    private val _state = MutableStateFlow(
        (restoreState() ?: initialState).apply {
            configureSavedStateProvider()
        }
    )

    protected val stateFlow: Flow<S>
        get() = _state.asStateFlow()

    protected val state: S
        get() = _state.value

    protected fun updateState(reducer: S.() -> S) {
        _state.update(reducer)
    }

    private fun configureSavedStateProvider() {
        savedStateHandle.setSavedStateProvider(key) {
            bundleOf("state" to state)
        }
    }

    private fun restoreState(): S? = with(savedStateHandle.get<Bundle>(key)) {
        this?.get("state") as? S
    }
}