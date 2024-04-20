package com.muammarahlnn.lsv.ui.pendingrequest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.pendingrequest.databinding.ScreenPendingRequestBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestFragment, 21/04/2024 02.59
 */
@AndroidEntryPoint
internal class PendingRequestFragment : BaseFragment<ScreenPendingRequestBinding, PendingRequestViewModel, PendingRequestUiState>() {

    override val viewModel: PendingRequestViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenPendingRequestBinding {
        return ScreenPendingRequestBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: PendingRequestUiState) {}

    private fun setupView() {
        viewBinding.toolbar.icBack.also { view ->
            view.setOnClickListener {
                back()
            }
        }
    }
}