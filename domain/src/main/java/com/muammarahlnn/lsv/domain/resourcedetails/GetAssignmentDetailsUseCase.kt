package com.muammarahlnn.lsv.domain.resourcedetails

import com.muammarahlnn.lsv.core.model.AssignmentDetailsModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.resourcedetails.ResourceDetailsRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetAssignmentDetailsUseCase, 23/05/2024 14.56
 */
class GetAssignmentDetailsUseCase @Inject constructor(
    private val resourceDetailsRepository: ResourceDetailsRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetAssignmentDetailsUseCase.Params, AssignmentDetailsModel>(dispatcher){

    override fun buildUseCase(params: Params): Flow<AssignmentDetailsModel> =
        resourceDetailsRepository.getAssignmentDetails(params.assignmentId)

    class Params(
        internal val assignmentId: String,
    )

}