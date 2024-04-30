package com.muammarahlnn.lsv.ui.login.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.muammarahlnn.lsv.core.navigation.navigateToHomeNavigator
import com.muammarahlnn.lsv.core.ui.ext.hideSoftKeyboard
import com.muammarahlnn.lsv.core.ui.ext.readDrawable
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.login.R
import com.muammarahlnn.lsv.ui.login.databinding.ScreenLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginUi, 11/03/2024 21.27
 */
@AndroidEntryPoint
internal class LoginFragment : BaseFragment<ScreenLoginBinding, LoginViewModel, LoginUiState>() {

    private val usernameFlow = MutableStateFlow("")

    private val passwordFLow = MutableStateFlow("")

    override val viewModel: LoginViewModel by viewModels()

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): ScreenLoginBinding {
        return ScreenLoginBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        observeLoginButtonEnabledState()
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
        viewBinding.etUsername.addTextChangedListener { text ->
            usernameFlow.update { text.toString() }
        }
        viewBinding.etPassword.addTextChangedListener { text ->
            passwordFLow.update { text.toString() }
        }

        viewBinding.btnLogin.also { button ->
            button.setOnClickListener {
                it.hideSoftKeyboard()

                viewModel.userLogin(
                    username = usernameFlow.value,
                    password = passwordFLow.value,
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
        navController.navigateToHomeNavigator()
    }

    private fun renderNormalState() {
        with(viewBinding) {
            btnLogin.background = readDrawable(R.drawable.bg_login_button_enabled)
            btnLogin.isEnabled = true

            btnLoginLoading.visibility = GONE
            btnLoginText.visibility = VISIBLE
        }
    }

    private fun observeLoginButtonEnabledState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                combine(usernameFlow, passwordFLow) { username, password ->
                    username.isNotBlank() && password.isNotBlank()
                }.collect { isLoginButtonEnabled ->
                    viewBinding.btnLogin.isEnabled = isLoginButtonEnabled
                    viewBinding.btnLogin.background = readDrawable(
                        if (isLoginButtonEnabled) R.drawable.bg_login_button_enabled
                        else R.drawable.bg_login_button_disabled
                    )
                }
            }
        }
    }
}