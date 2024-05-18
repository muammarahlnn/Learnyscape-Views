package com.muammarahlnn.lsv.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.EnrolledClassModel
import com.muammarahlnn.lsv.core.navigation.getRootNavController
import com.muammarahlnn.lsv.core.navigation.navigateToClassNavigator
import com.muammarahlnn.lsv.core.navigation.navigateToNotifications
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.home.adapter.ClassAdapter
import com.muammarahlnn.lsv.ui.home.databinding.ScreenHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeUI, 19/03/2024 02.35
 */
@AndroidEntryPoint
internal class HomeFragment : BaseFragment<ScreenHomeBinding, HomeViewModel, HomeUiState>() {

    override val viewModel: HomeViewModel by viewModels()

    private val adapter: ClassAdapter by lazy {
        ClassAdapter { enrolledClass ->
            requireActivity().getRootNavController().navigateToClassNavigator(enrolledClass.id)
        }
    }

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): ScreenHomeBinding {
        return ScreenHomeBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            viewModel.fetchEnrolledClasses()
        }
    }

    override fun renderState(state: HomeUiState) {
        when (state) {
            HomeUiState.Loading -> renderLoadingState()
            is HomeUiState.Success -> renderSuccessState(state.enrolledClasses)

            HomeUiState.SuccessEmpty -> {
                // TODO: add success empty state
            }

            is HomeUiState.Error -> {
                // TODO: add error state
            }
        }
    }

    private fun setupView() {
        viewBinding.searchBar.etSearch.also { view ->
            view.hint = readText(R.string.search_hint)
        }

        viewBinding.toolbar.icNotifications.also { view ->
            view.setOnClickListener {
                requireActivity().getRootNavController().navigateToNotifications()
            }
        }
    }

    private fun renderLoadingState() {
        with(viewBinding) {
            loading.root.show()

            searchBar.root.hide()
            rvClasses.hide()
        }
    }

    private fun renderSuccessState(enrolledClasses: List<EnrolledClassModel>) {
        with(viewBinding)  {
            loading.root.hide()

            searchBar.root.show()
            rvClasses.show()
        }

        viewBinding.rvClasses.also { view ->
            view.adapter = adapter.apply {
                setItems(enrolledClasses)
            }
        }
    }
}