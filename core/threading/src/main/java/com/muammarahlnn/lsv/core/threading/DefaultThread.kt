package com.muammarahlnn.lsv.core.threading

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DefaultThread, 10/03/2024 02.02
 */
class DefaultThread @Inject constructor() : Thread {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override fun reset() {}
}