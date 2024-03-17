package com.muammarahlnn.lsv.ui.login.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.login.databinding.ScreenLoginBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginUi, 11/03/2024 21.27
 */
@AndroidEntryPoint
class LoginUi : BaseFragment<ScreenLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by viewModels()

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): ScreenLoginBinding {
        return ScreenLoginBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {}
}