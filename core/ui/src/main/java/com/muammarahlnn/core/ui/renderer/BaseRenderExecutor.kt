@file:Suppress("UNCHECKED_CAST")

package com.muammarahlnn.core.ui.renderer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.muammarahlnn.core.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.scan

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseRendererExecutor, 08/03/2024 22.12
 */
abstract class BaseRenderExecutor<S>(
    renderer: BaseRenderer,
    private val viewModel: BaseViewModel<S, *>,
) : BaseRenderer by renderer {

    protected abstract fun render(oldState: S?, newState: S)

    private fun dispatch(oldState: S?, newState: S): S {
        render(oldState, newState)
        return newState
    }

    fun observeState() {
        viewModel.stateFlow
            .flowWithLifecycle(
                lifecycle = lifecycle,
                minActiveState = Lifecycle.State.RESUMED,
            )
            .scan(null as S, ::dispatch)
            .launchIn(scope = lifecycleScope)
    }
}