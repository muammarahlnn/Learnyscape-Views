package com.muammarahlnn.lsv.domain.assignmentsubmission

import com.muammarahlnn.lsv.core.model.AssignmentSubmissionModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.assignmentsubmission.AssignmentSubmissionRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File StudentGetAssignmentSubmissionUseCase, 10/06/2024 15.43
 */
class StudentGetAssignmentSubmissionUseCase @Inject constructor(
    private val assignmentSubmissionRepository: AssignmentSubmissionRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<StudentGetAssignmentSubmissionUseCase.Params, AssignmentSubmissionModel>(dispatcher) {

    override fun buildUseCase(params: Params): Flow<AssignmentSubmissionModel> =
        assignmentSubmissionRepository.studentGetAssignmentSubmission(params.assignmentId)

    class Params(
        internal val assignmentId: String,
    )
}