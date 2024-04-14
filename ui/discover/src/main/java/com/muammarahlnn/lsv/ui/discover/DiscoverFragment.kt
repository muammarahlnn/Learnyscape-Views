package com.muammarahlnn.lsv.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.AvailableClassModel
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
            showMessage(availableClass.name)
        }
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
    }

    override fun renderState(state: DiscoverUiState) {
        when (state) {
            is DiscoverUiState.FetchLoading -> renderLoadingState(state.loading)
            is DiscoverUiState.Error -> showMessage(state.message)
            is DiscoverUiState.Success -> renderSuccessState(state.availableClasses)
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
}