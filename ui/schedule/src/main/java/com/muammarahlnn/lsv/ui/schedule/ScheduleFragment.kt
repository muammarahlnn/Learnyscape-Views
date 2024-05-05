package com.muammarahlnn.lsv.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.ui.fragment.BaseFragment
import com.muammarahlnn.lsv.ui.schedule.databinding.ScreenScheduleBinding
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleUi, 19/03/2024 02.41
 */
@AndroidEntryPoint
internal class ScheduleFragment : BaseFragment<ScreenScheduleBinding, ScheduleViewModel, ScheduleState>() {

    override val viewModel: ScheduleViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenScheduleBinding {
        return ScreenScheduleBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
    }

    override fun renderState(state: ScheduleState) {}

    private fun setupView() {
        val localDateTimeNow = LocalDateTime.now()
        viewBinding.tvDay.also { view ->
            val dayOfWeekFormatter = DateTimeFormatter.ofPattern("EEEE")
            val currentDay = localDateTimeNow.format(dayOfWeekFormatter)
            view.text = currentDay
        }

        viewBinding.tvDate.also { view ->
            val dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
            val currentDate = localDateTimeNow.format(dateFormatter)
            view.text = currentDate
        }
    }
}