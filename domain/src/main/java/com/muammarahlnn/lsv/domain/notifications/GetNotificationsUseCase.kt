package com.muammarahlnn.lsv.domain.notifications

import com.muammarahlnn.lsv.core.model.NotificationModel
import com.muammarahlnn.lsv.core.threading.Dispatcher
import com.muammarahlnn.lsv.core.threading.LsvDispatchers.IO
import com.muammarahlnn.lsv.data.notifications.NotificationsRepository
import com.muammarahlnn.lsv.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File GetNotificationsUseCase, 20/04/2024 18.14
 */
class GetNotificationsUseCase @Inject constructor(
    private val repository: NotificationsRepository,
    @Dispatcher(IO) dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, List<NotificationModel>>(dispatcher) {

    override fun buildUseCase(params: Unit): Flow<List<NotificationModel>> =
        repository.getNotifications()
}