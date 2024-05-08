package com.muammarahlnn.lsv.network.profile

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.profile.response.ChangePhotoProfileResponse
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileApi, 29/04/2024 03.00
 */
interface ProfileApi {

    @GET("users/pic")
    suspend fun getProfilePic(): Response<ResponseBody>

    @Multipart
    @POST("users/pic")
    suspend fun postProfilePic(
        @Part pic: MultipartBody.Part,
    ): BaseResponse<ChangePhotoProfileResponse>
}