package com.muammarahlnn.lsv.core.ui.state

import com.muammarahlnn.lsv.core.ui.store.Store
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @Author Muammar Ahlan Abimanyu
 * @File State, 08/03/2024 20.52
 */
internal class StateStore<S>(initialState: S) : Store<S> {

    override val stateFlow: MutableStateFlow<S> = MutableStateFlow(initialState)

    override fun process(state: S) {
        stateFlow.value = state
    }
}