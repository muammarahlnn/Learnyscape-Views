package com.muammarahlnn.lsv.ui.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.discover.databinding.ScreenDiscoverBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverUi, 19/03/2024 02.03
 */
@AndroidEntryPoint
internal class DiscoverFragment : BaseFragment<ScreenDiscoverBinding, DiscoverViewModel>() {

    override val viewModel: DiscoverViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenDiscoverBinding {
        return ScreenDiscoverBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {}
}