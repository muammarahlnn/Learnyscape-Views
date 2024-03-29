package com.muammarahlnn.lsv.core.threading

import javax.inject.Qualifier

/**
 * @Author Muammar Ahlan Abimanyu
 * @File Dispatchers, 29/03/2024 18.33
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatchers: LsvDispatchers)

enum class LsvDispatchers {
    MAIN,
    IO,
    DEFAULT,
}