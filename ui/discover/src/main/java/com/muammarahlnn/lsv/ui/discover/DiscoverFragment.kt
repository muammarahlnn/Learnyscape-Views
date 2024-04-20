package com.muammarahlnn.lsv.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.AvailableClassModel
import com.muammarahlnn.lsv.core.navigation.getRootNavController
import com.muammarahlnn.lsv.core.navigation.navigateToPendingRequest
import com.muammarahlnn.lsv.core.ui.dialog.BaseDialog
import com.muammarahlnn.lsv.core.ui.dialog.LoadingDialog
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.discover.adapter.AvailableClassAdapter
import com.muammarahlnn.lsv.ui.discover.databinding.ScreenDiscoverBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverUi, 19/03/2024 02.03
 */
@AndroidEntryPoint
internal class DiscoverFragment : BaseFragment<ScreenDiscoverBinding, DiscoverViewModel, DiscoverUiState>() {

    override val viewModel: DiscoverViewModel by viewModels()

    private val adapter: AvailableClassAdapter by lazy {
        AvailableClassAdapter { availableClass ->
            if (!availableClass.isRequested()) {
                showRequestJoinClassDialog(availableClass)
            } else {
                showCancelRequestJoinClassDialog(availableClass)
            }
        }
    }

    private val loadingDialog: LoadingDialog by lazy {
        LoadingDialog()
    }

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenDiscoverBinding {
        return ScreenDiscoverBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            viewModel.fetchAvailableClasses()
        }
    }

    private fun setupView() {
        viewBinding.searchBar.etSearch.also { view ->
            view.hint = readText(R.string.search_hint)
        }

        viewBinding.toolbar.icPendingRequests.also { view ->
            view.setOnClickListener {
                requireActivity().getRootNavController().navigateToPendingRequest()
            }
        }
    }

    override fun renderState(state: DiscoverUiState) {
        when (state) {
            is DiscoverUiState.OnFetchAvailableClasses ->
                renderLoadingState(state.loading)

            is DiscoverUiState.OnErrorFetchAvailableClasses ->
                showMessage(state.message)

            is DiscoverUiState.OnSuccessFetchAvailableClasses ->
                renderSuccessState(state.availableClasses)

            is DiscoverUiState.OnRequestJoinClass ->
                renderRequestJonClassLoadingState(state.loading)

            is DiscoverUiState.OnErrorRequestJoinClass ->
                showMessage(state.message)

            is DiscoverUiState.OnSuccessRequestJoinClass ->
                showMessage(
                    if (!state.isCancelRequest) {
                        readText(R.string.success_join_request_class_message, state.className)
                    } else {
                        readText(R.string.success_cancel_join_request_class_message, state.className)
                    }
                )
        }
    }

    private fun renderLoadingState(isLoading: Boolean) {
        with(viewBinding) {
            if (isLoading) {
                shimmerLoading.root.show()
                searchBar.root.hide()
                rvAvailableClasses.hide()
            } else {
                shimmerLoading.root.hide()
                searchBar.root.show()
                rvAvailableClasses.show()
            }
        }
    }

    private fun renderSuccessState(availableClasses: List<AvailableClassModel>) {
        viewBinding.rvAvailableClasses.apply {
            adapter = this@DiscoverFragment.adapter.apply {
                setItems(availableClasses)
            }
        }
    }

    private fun showRequestJoinClassDialog(availableClass: AvailableClassModel) {
        BaseDialog(
            title = readText(R.string.join_request_dialog_title),
            message = readText(R.string.join_request_dialog_message, availableClass.name),
            positiveText = readText(R.string.join_request_dialog_positive_text),
            negativeText = readText(R.string.dialog_negative_text),
            onPositiveClick = { dialog ->
                viewModel.requestJoinClass(availableClass)
                dialog.dismiss()
            },
            onNegativeClick = { dialog -> dialog.dismiss() }
        ).show(activity?.supportFragmentManager)
    }

    private fun showCancelRequestJoinClassDialog(availableClass: AvailableClassModel) {
        BaseDialog(
            title = readText(R.string.cancel_request_dialog_title),
            message = readText(R.string.cancel_request_dialog_message, availableClass.name),
            positiveText = readText(R.string.cancel_request_dialog_positive_text),
            negativeText = readText(R.string.dialog_negative_text),
            onPositiveClick = { dialog ->
                viewModel.cancelRequestJoinClass(availableClass)
                dialog.dismiss()
            },
            onNegativeClick = { dialog -> dialog.dismiss() }
        ).show(activity?.supportFragmentManager)
    }

    private fun renderRequestJonClassLoadingState(loading: Boolean) {
        if (loading) loadingDialog.show(activity?.supportFragmentManager)
        else loadingDialog.hide()
    }
}