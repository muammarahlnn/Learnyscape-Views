package com.muammarahlnn.lsv.core.annotation

import kotlin.reflect.KClass

/**
 * @Author Muammar Ahlan Abimanyu
 * @File RenderWith, 10/03/2024 21.02
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class RenderWith(val state: KClass<*>)