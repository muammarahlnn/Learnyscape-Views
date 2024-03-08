package com.muammarahlnn.core.ui.store

import kotlinx.coroutines.flow.Flow

/**
 * @Author Muammar Ahlan Abimanyu
 * @File Store, 08/03/2024 20.30
 */
internal interface Store<S> {

    val stateFlow: Flow<S>

    fun process(state: S)
}