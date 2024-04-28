package com.muammarahlnn.lsv.network.profile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileNetworkDataSource, 29/04/2024 03.01
 */
@Singleton
class ProfileNetworkDataSource @Inject constructor(
    private val profileApi: ProfileApi,
) {

    fun getProfilePic(): Flow<Bitmap?> = flow {
        emit(profileApi.getProfilePic().toBitmap())
    }

    private fun Response<ResponseBody>.toBitmap(): Bitmap? = if (isSuccessful) {
        val imageBytes = body()?.bytes() ?: byteArrayOf()
        BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    } else null
}