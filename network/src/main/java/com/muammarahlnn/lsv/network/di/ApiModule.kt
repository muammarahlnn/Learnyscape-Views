package com.muammarahlnn.lsv.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.muammarahlnn.lsv.network.assignmentsubmission.AssignmentSubmissionApi
import com.muammarahlnn.lsv.network.attachment.AttachmentApi
import com.muammarahlnn.lsv.network.base.Server
import com.muammarahlnn.lsv.network.changepassword.ChangePasswordApi
import com.muammarahlnn.lsv.network.classfeed.ClassFeedApi
import com.muammarahlnn.lsv.network.classmember.ClassMemberApi
import com.muammarahlnn.lsv.network.classoverview.ClassOverviewApi
import com.muammarahlnn.lsv.network.di.AuthQualifiers.BEARER_TOKEN
import com.muammarahlnn.lsv.network.di.AuthQualifiers.DEFAULT
import com.muammarahlnn.lsv.network.discover.DiscoverApi
import com.muammarahlnn.lsv.network.home.HomeApi
import com.muammarahlnn.lsv.network.login.LoginApi
import com.muammarahlnn.lsv.network.notifications.NotificationsApi
import com.muammarahlnn.lsv.network.pendingrequest.PendingRequestApi
import com.muammarahlnn.lsv.network.profile.ProfileApi
import com.muammarahlnn.lsv.network.resourcedetails.ResourceDetailsApi
import com.muammarahlnn.lsv.network.schedule.ScheduleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ApiModule, 30/03/2024 15.10
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    fun providesLoginApi(
        networkJson: Json,
        @Auth(DEFAULT) client: OkHttpClient,
    ): LoginApi = buildRetrofit(networkJson, client).create(LoginApi::class.java)

    @Provides
    @Singleton
    fun providesHomeApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): HomeApi = buildRetrofit(networkJson, client).create(HomeApi::class.java)

    @Provides
    @Singleton
    fun providesDiscoverApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): DiscoverApi = buildRetrofit(networkJson, client).create(DiscoverApi::class.java)

    @Provides
    @Singleton
    fun providesNotificationsApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): NotificationsApi = buildRetrofit(networkJson, client).create(NotificationsApi::class.java)

    @Provides
    @Singleton
    fun providesPendingRequestApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): PendingRequestApi = buildRetrofit(networkJson, client).create(PendingRequestApi::class.java)

    @Provides
    @Singleton
    fun providesProfileApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): ProfileApi = buildRetrofit(networkJson, client).create(ProfileApi::class.java)

    @Provides
    @Singleton
    fun providesChangePasswordApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): ChangePasswordApi = buildRetrofit(networkJson, client).create(ChangePasswordApi::class.java)

    @Provides
    @Singleton
    fun providesScheduleApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): ScheduleApi = buildRetrofit(networkJson, client).create(ScheduleApi::class.java)

    @Provides
    @Singleton
    fun providesClassOverviewApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): ClassOverviewApi = buildRetrofit(networkJson, client).create(ClassOverviewApi::class.java)

    @Provides
    @Singleton
    fun providesClassMemberApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): ClassMemberApi = buildRetrofit(networkJson, client).create(ClassMemberApi::class.java)

    @Provides
    @Singleton
    fun providesClassFeedApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): ClassFeedApi = buildRetrofit(networkJson, client).create(ClassFeedApi::class.java)

    @Provides
    @Singleton
    fun providesResourceDetailsApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): ResourceDetailsApi = buildRetrofit(networkJson, client).create(ResourceDetailsApi::class.java)

    @Provides
    @Singleton
    fun providesAttachmentApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): AttachmentApi = buildRetrofit(networkJson, client).create(AttachmentApi::class.java)

    @Provides
    @Singleton
    fun providesAssignmentSubmissionApi(
        networkJson: Json,
        @Auth(BEARER_TOKEN) client: OkHttpClient,
    ): AssignmentSubmissionApi = buildRetrofit(networkJson, client).create(AssignmentSubmissionApi::class.java)
}

private fun buildRetrofit(
    networkJson: Json,
    client: OkHttpClient,
): Retrofit = Retrofit.Builder()
    .baseUrl(Server.BASE_URL)
    .addConverterFactory(
        networkJson.asConverterFactory("application/json".toMediaType())
    )
    .client(client)
    .build()