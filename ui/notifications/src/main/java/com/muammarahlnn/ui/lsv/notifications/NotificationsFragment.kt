package com.muammarahlnn.ui.lsv.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.notifications.databinding.ScreenNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsFragment, 20/04/2024 15.45
 */
@AndroidEntryPoint
internal class NotificationsFragment : BaseFragment<ScreenNotificationsBinding, NotificationsViewModel, NotificationsUiState>() {

    override val viewModel: NotificationsViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenNotificationsBinding {
        return ScreenNotificationsBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: NotificationsUiState) {}

    private fun setupView() {
        viewBinding.toolbar.icBack.also { view ->
            view.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}