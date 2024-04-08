package com.muammarahlnn.lsv.domain.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseSuspendUseCase, 08/04/2024 06.14
 */
abstract class BaseSuspendUseCase<Params> {

    fun execute(
        params: Params,
        scope: CoroutineScope,
    ) {
        scope.launch { buildUseCase(params) }
    }

    abstract suspend fun buildUseCase(params: Params)
}

fun BaseSuspendUseCase<Unit>.execute(scope: CoroutineScope) = execute(Unit, scope)