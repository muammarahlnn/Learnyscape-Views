package com.muammarahlnn.lsv.core.threading

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @Author Muammar Ahlan Abimanyu
 * @File Thread, 10/03/2024 02.01
 */
interface Thread {

    val main: CoroutineDispatcher

    val default: CoroutineDispatcher

    val io: CoroutineDispatcher

    fun reset()
}