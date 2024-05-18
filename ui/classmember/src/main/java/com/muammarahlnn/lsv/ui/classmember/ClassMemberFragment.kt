package com.muammarahlnn.lsv.ui.classmember

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.classmember.databinding.ScreenClassMemberBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberFragment, 12/05/2024 02.46
 */
@AndroidEntryPoint
internal class ClassMemberFragment :
    BaseFragment<ScreenClassMemberBinding, ClassMemberViewModel, ClassMemberState>() {

    override val viewModel: ClassMemberViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenClassMemberBinding {
        return ScreenClassMemberBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: ClassMemberState) {
    }

    private fun setupView() {

    }
}