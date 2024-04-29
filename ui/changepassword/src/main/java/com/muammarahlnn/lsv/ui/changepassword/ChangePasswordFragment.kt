package com.muammarahlnn.lsv.ui.changepassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.changepassword.databinding.ScreenChangePasswordBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordFragment, 29/04/2024 19.44
 */
@AndroidEntryPoint
internal class ChangePasswordFragment :
    BaseFragment<ScreenChangePasswordBinding, ChangePasswordViewModel, ChangePasswordUiState>() {

    override val viewModel: ChangePasswordViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenChangePasswordBinding = ScreenChangePasswordBinding.inflate(inflater, container, false)

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {}

    override fun renderState(state: ChangePasswordUiState) {}
}