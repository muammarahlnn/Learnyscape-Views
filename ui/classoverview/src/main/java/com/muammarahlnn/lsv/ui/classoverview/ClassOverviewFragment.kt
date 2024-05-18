package com.muammarahlnn.lsv.ui.classoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.classoverview.databinding.ScreenClassOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewFragment, 12/05/2024 00.10
 */
@AndroidEntryPoint
internal class ClassOverviewFragment :
    BaseFragment<ScreenClassOverviewBinding, ClassOverviewViewModel, ClassOverviewState>() {

    override val viewModel: ClassOverviewViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenClassOverviewBinding {
        return ScreenClassOverviewBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: ClassOverviewState) {
    }

    private fun setupView() {
    }
}