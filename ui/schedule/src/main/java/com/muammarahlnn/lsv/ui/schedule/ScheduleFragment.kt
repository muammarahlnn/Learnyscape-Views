package com.muammarahlnn.lsv.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.schedule.databinding.ScreenScheduleBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleUi, 19/03/2024 02.41
 */
@AndroidEntryPoint
internal class ScheduleFragment : BaseFragment<ScreenScheduleBinding, ScheduleViewModel>() {

    override val viewModel: ScheduleViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenScheduleBinding {
        return ScreenScheduleBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {}
}