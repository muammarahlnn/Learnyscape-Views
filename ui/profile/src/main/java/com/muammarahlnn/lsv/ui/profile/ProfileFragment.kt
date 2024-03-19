package com.muammarahlnn.lsv.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.profile.databinding.ScreenProfileBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileUi, 19/03/2024 02.38
 */
@AndroidEntryPoint
internal class ProfileFragment : BaseFragment<ScreenProfileBinding, ProfileViewModel>( ){

    override val viewModel: ProfileViewModel by viewModels()

    override fun createView(inflater: LayoutInflater, container: ViewGroup?): ScreenProfileBinding {
        return ScreenProfileBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {}
}