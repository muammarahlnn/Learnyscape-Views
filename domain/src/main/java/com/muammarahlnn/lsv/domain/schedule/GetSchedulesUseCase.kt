package com.muammarahlnn.lsv.domain.schedule

import com.muammarahlnn.lsv.core.model.ScheduleModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.schedule.ScheduleRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetSchedulesUseCase, 06/05/2024 14.37
 */
class GetSchedulesUseCase @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, List<ScheduleModel>>(dispatcher) {

    override fun buildUseCase(params: Unit): Flow<List<ScheduleModel>> =
        scheduleRepository.getSchedules()
}