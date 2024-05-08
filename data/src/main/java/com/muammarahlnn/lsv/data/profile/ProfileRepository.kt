package com.muammarahlnn.lsv.data.profile

import android.graphics.Bitmap
import com.muammarahlnn.lsv.core.model.UserModel
import com.muammarahlnn.lsv.data.login.mapper.UserEntityToModel
import com.muammarahlnn.lsv.datastore.LsvPreferencesDataSource
import com.muammarahlnn.lsv.network.profile.ProfileNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.File
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileRepository, 08/04/2024 05.56
 */
class ProfileRepository @Inject constructor(
    private val lsvPreferencesDataSource: LsvPreferencesDataSource,
    private val profileNetworkDataSource: ProfileNetworkDataSource,
    private val userEntityToModel: UserEntityToModel,
) {

    suspend fun userLogout() {
        lsvPreferencesDataSource.removeUser()
    }

    fun getCurrentUser(): Flow<UserModel> =
        lsvPreferencesDataSource.getUser().map(userEntityToModel::map)

    fun getProfilePic(): Flow<Bitmap?> =
        profileNetworkDataSource.getProfilePic()

    fun changeProfilePic(pic: File): Flow<String> =
        profileNetworkDataSource.postProfilePic(pic).map {
            it.name
        }

}