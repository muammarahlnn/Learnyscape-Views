package com.muammarahlnn.ui.lsv.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.NotificationModel
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.notifications.databinding.ScreenNotificationsBinding
import com.muammarahlnn.ui.lsv.notifications.adapter.NotificationsAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsFragment, 20/04/2024 15.45
 */
@AndroidEntryPoint
internal class NotificationsFragment : BaseFragment<ScreenNotificationsBinding, NotificationsViewModel, NotificationsUiState>() {

    override val viewModel: NotificationsViewModel by viewModels()

    private val adapter: NotificationsAdapter by lazy {
        NotificationsAdapter { notification ->
            showMessage(notification.title)
        }
    }

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenNotificationsBinding {
        return ScreenNotificationsBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            viewModel.fetchNotifications()
        }
    }

    override fun renderState(state: NotificationsUiState) {
        when (state) {
            is NotificationsUiState.OnFetchNotifications ->
                renderLoadingState(state.fetching)

            is NotificationsUiState.OnErrorFetchNotifications ->
                showMessage(state.message)

            is NotificationsUiState.OnSuccessFetchNotifications ->
                renderSuccessState(state.notifications)
        }
    }

    private fun setupView() {
        viewBinding.toolbar.icBack.also { view ->
            view.setOnClickListener {
                back()
            }
        }
    }

    private fun renderLoadingState(loading: Boolean) {
        with(viewBinding) {
            if (loading) {
                shimmerLoading.root.show()
                rvNotifications.hide()
            } else {
                shimmerLoading.root.hide()
                rvNotifications.show()
            }
        }
    }

    private fun renderSuccessState(notifications: List<NotificationModel>) {
        viewBinding.rvNotifications.apply {
            adapter = this@NotificationsFragment.adapter.apply {
                setItems(notifications)
            }
        }
    }
}