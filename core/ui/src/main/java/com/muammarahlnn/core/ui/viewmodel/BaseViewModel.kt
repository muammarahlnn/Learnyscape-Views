@file:Suppress("UNCHECKED_CAST")

package com.muammarahlnn.core.ui.viewmodel

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.muammarahlnn.core.ui.event.EventStore
import com.muammarahlnn.core.ui.state.StateStore
import com.muammarahlnn.core.ui.store.Store
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseViewModel, 08/03/2024 20.56
 */
abstract class BaseViewModel<S, E>(
    initialState: S,
    protected val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val key: String
        get() = javaClass.name

    private val stateStore: Store<S> = StateStore(
        initialState = (restoreState() ?: initialState).apply {
            configureSavedStateProvider()
        }
    )

    private val eventStore: Store<E> = EventStore()

    internal val stateFlow: Flow<S>
        get() = stateStore.stateFlow

    internal val eventFlow: Flow<E>
        get() = eventStore.stateFlow.filter { it != null }

    protected val state: S
        get() = (stateStore.stateFlow as StateFlow).value

    private fun configureSavedStateProvider() {
        savedStateHandle.setSavedStateProvider(key) {
            bundleOf("state" to state)
        }
    }

    private fun restoreState(): S? = with(savedStateHandle.get<Bundle>(key)) {
        this?.get("state") as? S
    }

    protected fun render(newState: S) {
        stateStore.process(newState)
    }

    protected fun action(newEvent: E) {
        eventStore.process(newEvent)
    }
}

/**
 * <?xml version="1.0" encoding="utf-8"?>
 * <shape xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:shape="rectangle">
 *
 *     <corners
 *         android:topLeftRadius="24dp"
 *         android:topRightRadius="24dp" />
 *
 *     <solid />
 *
 * </shape>
 */


