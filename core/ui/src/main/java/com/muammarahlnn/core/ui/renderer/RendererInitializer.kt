package com.muammarahlnn.core.ui.renderer

/**
 * @Author Muammar Ahlan Abimanyu
 * @File RendererInitializer, 08/03/2024 22.12
 */
interface RendererInitializer<R, VM> {

    fun init(renderer: R, viewModel: VM)
}