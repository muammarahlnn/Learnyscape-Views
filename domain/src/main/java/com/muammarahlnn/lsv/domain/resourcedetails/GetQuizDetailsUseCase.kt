package com.muammarahlnn.lsv.domain.resourcedetails

import com.muammarahlnn.lsv.core.model.QuizDetailsModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.resourcedetails.ResourceDetailsRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetQuizDetailsUseCase, 23/05/2024 14.57
 */
class GetQuizDetailsUseCase @Inject constructor(
    private val resourceDetailsRepository: ResourceDetailsRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetQuizDetailsUseCase.Params, QuizDetailsModel>(dispatcher){

    override fun buildUseCase(params: Params): Flow<QuizDetailsModel> =
        resourceDetailsRepository.getQuizDetails(params.quizId)

    class Params(
        internal val quizId: String,
    )

}