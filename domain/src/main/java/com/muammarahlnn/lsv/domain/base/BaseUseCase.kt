package com.muammarahlnn.lsv.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseUseCase, 04/04/2024 00.36
 */
abstract class BaseUseCase<Params, T>(
    private val dispatcher: CoroutineDispatcher,
) {

    fun execute(
        params: Params,
        coroutineScope: CoroutineScope,
        onStart: () -> Unit = {},
        onSuccess: (T) -> Unit = {},
        onError: (Throwable) -> Unit = {},
        onCompletion: () -> Unit = {},
    ) {
        buildUseCase(params)
            .flowOn(dispatcher)
            .onStart { onStart() }
            .onEach { onSuccess(it) }
            .catch { onError(it) }
            .onCompletion { onCompletion() }
            .launchIn(coroutineScope)
    }

    abstract fun buildUseCase(params: Params): Flow<T>
}
