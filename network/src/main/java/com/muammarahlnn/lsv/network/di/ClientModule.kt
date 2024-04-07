package com.muammarahlnn.lsv.network.di

import com.muammarahlnn.lsv.network.BuildConfig
import com.muammarahlnn.lsv.network.di.AuthQualifiers.DEFAULT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ApiModule, 30/03/2024 03.49
 */
@Module
@InstallIn(SingletonComponent::class)
object ClientModule {

    @Provides
    @Singleton
    @Auth(DEFAULT)
    fun providesDefaultOkhttpClient(): OkHttpClient = buildOkHttpClient()
}

private fun buildOkHttpClient(interceptor: Interceptor? = null): OkHttpClient =
    OkHttpClient.Builder().apply {
        if (interceptor != null) {
            addInterceptor(interceptor)
        }
        addInterceptor(
            HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            }
        )
    }.build()