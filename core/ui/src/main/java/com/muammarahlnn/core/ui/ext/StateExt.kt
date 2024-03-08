package com.muammarahlnn.core.ui.ext

import com.muammarahlnn.core.ui.state.BaseState

/**
 * @Author Muammar Ahlan Abimanyu
 * @File StateExtensions, 08/03/2024 22.22
 */
fun <S: BaseState> S.reduce(reduceState: S.() -> S): S = reduceState()