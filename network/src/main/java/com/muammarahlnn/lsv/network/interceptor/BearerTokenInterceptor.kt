package com.muammarahlnn.lsv.network.interceptor

import com.muammarahlnn.lsv.datastore.LsvPreferencesDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author Muammar Ahlan Abimanyu
 * @File BearerTokenInterceptor, 09/04/2024 03.39
 */
class BearerTokenInterceptor(
    private val lsvPreferencesDataSource: LsvPreferencesDataSource,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking {
            lsvPreferencesDataSource.getAccessToken().first()
        }
        val request = chain.request().newBuilder()
            .header(
                name = "Authorization",
                value = "Bearer $token",
            )
            .build()

        return chain.proceed(request)
    }
}