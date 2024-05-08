package com.muammarahlnn.lsv.network.profile

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.muammarahlnn.lsv.network.profile.response.ChangePhotoProfileResponse
import com.muammarahlnn.lsv.network.util.toImageRequestBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.File
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

    fun postProfilePic(pic: File): Flow<ChangePhotoProfileResponse> = flow {
        val profilePicBody = pic.toImageRequestBody()
        val profilePicMultipart = MultipartBody.Part.createFormData(
            "pic",
            pic.name,
            profilePicBody
        )
        emit(profileApi.postProfilePic(profilePicMultipart).data)
    }

    private fun Response<ResponseBody>.toBitmap(): Bitmap? = if (isSuccessful) {
        val imageBytes = body()?.bytes() ?: byteArrayOf()
        BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    } else null
}