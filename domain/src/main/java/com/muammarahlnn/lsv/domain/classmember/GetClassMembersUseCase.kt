package com.muammarahlnn.lsv.domain.classmember

import com.muammarahlnn.lsv.core.model.ClassMembersModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.classmember.ClassMemberRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetClassMembersUseCase, 20/05/2024 20.47
 */
class GetClassMembersUseCase @Inject constructor(
    private val classMemberRepository: ClassMemberRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetClassMembersUseCase.Params, ClassMembersModel>(dispatcher) {

    override fun buildUseCase(params: Params): Flow<ClassMembersModel> =
        classMemberRepository.getClassMembers(params.classId)

    class Params(
        internal val classId: String,
    )
}