package com.muammarahlnn.lsv.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.muammarahlnn.lsv.network.base.Server
import com.muammarahlnn.lsv.network.di.AuthQualifiers.BEARER_TOKEN
import com.muammarahlnn.lsv.network.di.AuthQualifiers.DEFAULT
import com.muammarahlnn.lsv.network.home.HomeApi
import com.muammarahlnn.lsv.network.login.LoginApi
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