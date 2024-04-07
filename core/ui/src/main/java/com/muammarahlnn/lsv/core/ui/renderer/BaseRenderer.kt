package com.muammarahlnn.lsv.core.ui.renderer

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BaseRenderer, 04/04/2024 01.13
 */
interface BaseRenderer<S> {

    fun renderState(state: S)
}