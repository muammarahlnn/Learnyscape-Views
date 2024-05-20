package com.muammarahlnn.lsv.network.classmember

import com.muammarahlnn.lsv.network.base.BaseResponse
import com.muammarahlnn.lsv.network.classmember.response.ClassMembersResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberApi, 20/05/2024 20.24
 */
interface ClassMemberApi {

    @GET("users/classes/{classId}/students")
    suspend fun getClassMembers(
        @Path("classId") classId: String,
    ): BaseResponse<ClassMembersResponse>
}