@file:Suppress("UNCHECKED_CAST")

package com.muammarahlnn.lsv.core.ui.event

import com.muammarahlnn.lsv.core.ui.store.Store
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @Author Muammar Ahlan Abimanyu
 * @File EventStore, 08/03/2024 20.54
 */
internal class EventStore<E> : Store<E> {

    override val stateFlow: MutableStateFlow<E> = MutableStateFlow(null as E)

    override fun process(state: E) {
        stateFlow.value = state
    }
}