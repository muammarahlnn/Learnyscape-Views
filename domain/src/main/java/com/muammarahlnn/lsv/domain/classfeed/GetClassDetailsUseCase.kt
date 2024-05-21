package com.muammarahlnn.lsv.domain.classfeed

import com.muammarahlnn.lsv.core.model.ClassDetailsModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.classfeed.ClassFeedRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetClassDetailsUseCase, 21/05/2024 04.25
 */
class GetClassDetailsUseCase @Inject constructor(
    private val classFeedRepository: ClassFeedRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetClassDetailsUseCase.Params, ClassDetailsModel>(dispatcher) {

    override fun buildUseCase(params: Params): Flow<ClassDetailsModel> =
        classFeedRepository.getClassDetails(params.classId)

    class Params(
        internal val classId: String,
    )
}