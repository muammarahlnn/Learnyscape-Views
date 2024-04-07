package com.muammarahlnn.lsv.datastore.di

import android.content.Context
import com.muammarahlnn.lsv.datastore.LsvPreferencesDataSource
import com.muammarahlnn.lsv.datastore.lsvPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DataStoreModule, 30/03/2024 19.26
 */
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providesLsvPreferencesDataStore(
        @ApplicationContext context: Context,
    ): LsvPreferencesDataSource = LsvPreferencesDataSource(context.lsvPreferences)
}