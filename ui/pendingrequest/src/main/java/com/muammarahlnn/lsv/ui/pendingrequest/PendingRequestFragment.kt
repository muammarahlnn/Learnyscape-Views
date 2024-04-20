package com.muammarahlnn.lsv.ui.pendingrequest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.PendingRequestModel
import com.muammarahlnn.lsv.core.ui.dialog.BaseDialog
import com.muammarahlnn.lsv.core.ui.dialog.LoadingDialog
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.pendingrequest.adapter.PendingRequestsAdapter
import com.muammarahlnn.lsv.ui.pendingrequest.databinding.ScreenPendingRequestBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestFragment, 21/04/2024 02.59
 */
@AndroidEntryPoint
internal class PendingRequestFragment : BaseFragment<ScreenPendingRequestBinding, PendingRequestViewModel, PendingRequestUiState>() {

    override val viewModel: PendingRequestViewModel by viewModels()

    private val adapter: PendingRequestsAdapter by lazy {
        PendingRequestsAdapter { pendingRequest ->
            showCancelRequestJoinClassDialog(pendingRequest)
        }
    }

    private val loadingDialog: LoadingDialog by lazy { LoadingDialog() }

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenPendingRequestBinding {
        return ScreenPendingRequestBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            viewModel.fetchPendingRequests()
        }
    }

    override fun renderState(state: PendingRequestUiState) {
        when (state) {
            is PendingRequestUiState.OnFetchPendingRequests ->
                renderLoadingState(state.fetching)

            is PendingRequestUiState.OnErrorFetchPendingRequests ->
                showMessage(state.message)

            is PendingRequestUiState.OnSuccessFetchingPendingRequests ->
                renderSuccessState(state.pendingRequests)

            is PendingRequestUiState.OnCancelRequestJoinClass ->
                renderCancelRequestJoinClassLoadingState(state.loading)

            is PendingRequestUiState.OnErrorCancelRequestJoinClass ->
                showMessage(state.message)

            is PendingRequestUiState.OnSuccessCancelRequestJoinClass ->
                showMessage(
                    readText(R.string.success_cancel_join_request_class_message, state.className)
                )
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
                rvPendingRequests.hide()
            } else {
                shimmerLoading.root.hide()
                rvPendingRequests.show()
            }
        }
    }

    private fun renderSuccessState(pendingRequests: List<PendingRequestModel>) {
        viewBinding.rvPendingRequests.apply {
            adapter = this@PendingRequestFragment.adapter.apply {
                setItems(pendingRequests)
            }
        }
    }

    private fun showCancelRequestJoinClassDialog(pendingRequest: PendingRequestModel) {
        BaseDialog(
            title = readText(R.string.cancel_request_dialog_title),
            message = readText(
                R.string.cancel_request_dialog_message,
                pendingRequest.className
            ),
            positiveText = readText(R.string.cancel_request_dialog_positive_text),
            negativeText = readText(R.string.cancel_request_dialog_negative_text),
            onPositiveClick = { dialog ->
                viewModel.cancelRequestJoinClass(pendingRequest)
                dialog.dismiss()
            },
            onNegativeClick = { dialog -> dialog.dismiss() }
        ).show(activity?.supportFragmentManager)
    }

    private fun renderCancelRequestJoinClassLoadingState(loading: Boolean) {
        if (loading) loadingDialog.show(activity?.supportFragmentManager)
        else loadingDialog.hide()
    }
}