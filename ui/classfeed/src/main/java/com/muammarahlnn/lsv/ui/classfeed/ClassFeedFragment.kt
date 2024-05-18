package com.muammarahlnn.lsv.ui.classfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.classfeed.databinding.ScreenClassFeedBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedFragment, 12/05/2024 02.37
 */
@AndroidEntryPoint
internal class ClassFeedFragment :
    BaseFragment<ScreenClassFeedBinding, ClassFeedViewModel, ClassFeedState>() {

    override val viewModel: ClassFeedViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenClassFeedBinding {
        return ScreenClassFeedBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: ClassFeedState) {
    }

    private fun setupView() {

    }
}