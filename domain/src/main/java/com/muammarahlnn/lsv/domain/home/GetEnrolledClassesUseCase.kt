package com.muammarahlnn.lsv.domain.home

import com.muammarahlnn.lsv.core.model.EnrolledClassModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.home.HomeRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetEnrolledClassesUseCase, 09/04/2024 03.55
 */
class GetEnrolledClassesUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, List<EnrolledClassModel>>(dispatcher) {

    override fun buildUseCase(params: Unit): Flow<List<EnrolledClassModel>> =
        homeRepository.getEnrolledClasses()
}