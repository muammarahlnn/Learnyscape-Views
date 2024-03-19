package com.muammarahlnn.lsv.ui.login.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muammarahlnn.lsv.core.navigation.navigateToHomeNavigator
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.login.databinding.ScreenLoginBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginUi, 11/03/2024 21.27
 */
@AndroidEntryPoint
internal class LoginFragment : BaseFragment<ScreenLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by viewModels()

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): ScreenLoginBinding {
        return ScreenLoginBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        viewBinding.btnLogin.also { button ->
            button.setOnClickListener {
                findNavController().navigateToHomeNavigator()
            }
        }
    }
}