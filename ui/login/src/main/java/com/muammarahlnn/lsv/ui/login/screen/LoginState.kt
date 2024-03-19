package com.muammarahlnn.lsv.ui.login.screen

import com.muammarahlnn.lsv.core.ui.state.BaseState

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginState, 11/03/2024 21.21
 */
internal data class LoginState(
    val username: String = "",
    val password: String = "",
) : BaseState()