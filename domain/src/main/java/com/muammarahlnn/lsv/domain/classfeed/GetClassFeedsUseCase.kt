package com.muammarahlnn.lsv.domain.classfeed

import com.muammarahlnn.lsv.core.model.ClassFeedModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.classfeed.ClassFeedRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetClassFeedsUseCase, 21/05/2024 04.26
 */
class GetClassFeedsUseCase @Inject constructor(
    private val classFeedRepository: ClassFeedRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher
) : BaseUseCase<GetClassFeedsUseCase.Params, List<ClassFeedModel>>(dispatcher) {

    override fun buildUseCase(params: Params): Flow<List<ClassFeedModel>> =
        classFeedRepository.getClassFeeds(params.classId)

    class Params(
        internal val classId: String,
    )
}