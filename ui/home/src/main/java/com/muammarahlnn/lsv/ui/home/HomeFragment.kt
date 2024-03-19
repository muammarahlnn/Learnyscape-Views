package com.muammarahlnn.lsv.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.home.databinding.ScreenHomeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeUI, 19/03/2024 02.35
 */
@AndroidEntryPoint
internal class HomeFragment : BaseFragment<ScreenHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): ScreenHomeBinding {
        return ScreenHomeBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {}
}