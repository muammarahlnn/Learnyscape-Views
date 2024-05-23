package com.muammarahlnn.lsv.domain.resourcedetails

import com.muammarahlnn.lsv.core.model.AnnouncementDetailsModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.resourcedetails.ResourceDetailsRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetAnnouncementDetails, 23/05/2024 14.52
 */
class GetAnnouncementDetailsUseCase @Inject constructor(
    private val resourceDetailsRepository: ResourceDetailsRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<GetAnnouncementDetailsUseCase.Params, AnnouncementDetailsModel>(dispatcher) {

    override fun buildUseCase(params: Params): Flow<AnnouncementDetailsModel> =
        resourceDetailsRepository.getAnnouncementDetails(params.announcementId)

    class Params(
        internal val announcementId: String,
    )
}