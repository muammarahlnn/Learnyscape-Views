package com.muammarahlnn.lsv.data.profile

import com.muammarahlnn.lsv.datastore.LsvPreferencesDataSource
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileRepository, 08/04/2024 05.56
 */
class ProfileRepository @Inject constructor(
    private val lsvPreferencesDataSource: LsvPreferencesDataSource,
) {

    suspend fun userLogout() {
        lsvPreferencesDataSource.removeUser()
    }
}