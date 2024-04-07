package com.muammarahlnn.lsv.ui.login.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muammarahlnn.lsv.core.navigation.navigateToHomeNavigator
import com.muammarahlnn.lsv.core.ui.ext.hideSoftKeyboard
import com.muammarahlnn.lsv.core.ui.ext.readDrawable
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.login.R
import com.muammarahlnn.lsv.ui.login.databinding.ScreenLoginBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginUi, 11/03/2024 21.27
 */
@AndroidEntryPoint
internal class LoginFragment : BaseFragment<ScreenLoginBinding, LoginViewModel, LoginUiState>() {

    override val viewModel: LoginViewModel by viewModels()

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): ScreenLoginBinding {
        return ScreenLoginBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: LoginUiState) {
        when (state) {
            LoginUiState.Loading -> renderLoadingState()
            is LoginUiState.OnErrorLogin -> renderErrorState(state.message)
            LoginUiState.OnSuccessLogin -> renderSuccessState()
            else -> Unit
        }
    }

    private fun setupView() {
        viewBinding.btnLogin.also { button ->
            button.setOnClickListener {
                it.hideSoftKeyboard()

                viewModel.userLogin(
                    username = viewBinding.etUsername.text.toString(),
                    password = viewBinding.etPassword.text.toString()
                )
            }
        }
    }

    private fun renderLoadingState() {
        with(viewBinding) {
            btnLogin.background = readDrawable(R.drawable.bg_login_button_disabled)
            btnLogin.isEnabled = false

            btnLoginLoading.visibility = VISIBLE
            btnLoginText.visibility = GONE
        }
    }

    private fun renderErrorState(errorMessage: String) {
        renderNormalState()
        showMessage(errorMessage)
    }

    private fun renderSuccessState() {
        navigateToHome()
    }

    private fun renderNormalState() {
        with(viewBinding) {
            btnLogin.background = readDrawable(R.drawable.bg_login_button_enabled)
            btnLogin.isEnabled = true

            btnLoginLoading.visibility = GONE
            btnLoginText.visibility = VISIBLE
        }
    }

    private fun navigateToHome() {
        findNavController().navigateToHomeNavigator()
    }
}