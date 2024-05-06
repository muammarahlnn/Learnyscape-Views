package com.muammarahlnn.lsv.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.muammarahlnn.lsv.core.model.ScheduleModel
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.ext.show
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
internal class ScheduleFragment : BaseFragment<ScreenScheduleBinding, ScheduleViewModel, ScheduleUiState>() {

    override val viewModel: ScheduleViewModel by viewModels()

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ScreenScheduleBinding {
        return ScreenScheduleBinding.inflate(inflater, container, false)
    }

    override suspend fun onViewLoaded(savedInstanceState: Bundle?) {
        setupView()
        if (savedInstanceState == null) {
            viewModel.fetchSchedules()
        }
    }

    override fun renderState(state: ScheduleUiState) {
        when (state) {
            is ScheduleUiState.Loading ->
                renderLoadingState(state.isLoading)

            is ScheduleUiState.Success ->
                renderSuccessState(state.schedules)

            ScheduleUiState.SuccessEmpty ->
                renderSchedulesEmptyState()

            is ScheduleUiState.Error ->
                renderErrorState(state.message)
        }
    }

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

    private fun renderLoadingState(isLoading: Boolean) {
        with(viewBinding) {
            if (isLoading) {
                shimmerLoading.root.show()
                scheduleCalendar.hide()
            } else {
                shimmerLoading.root.hide()
            }
        }
    }

    private fun renderSuccessState(schedules: List<ScheduleModel>) {
        with(viewBinding) {
            scheduleCalendar.apply {
                show()
                setupSchedules(schedules) { className ->
                    Toast.makeText(context, className, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun renderSchedulesEmptyState() {
        viewBinding.emptyState.also { layout ->
            layout.root.show()
            layout.tvDesc.text = readText(R.string.empty_schedules_desc)
        }
    }

    private fun renderErrorState(message: String) {
        viewBinding.errorState.also { layout ->
            layout.root.show()
            layout.tvDesc.text = message
        }
    }
}