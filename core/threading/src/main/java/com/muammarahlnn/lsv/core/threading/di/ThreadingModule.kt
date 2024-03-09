package com.muammarahlnn.lsv.core.threading.di

import com.muammarahlnn.lsv.core.threading.DefaultThread
import com.muammarahlnn.lsv.core.threading.Thread
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ThreadingModule, 10/03/2024 02.08
 */
@Module
@InstallIn(SingletonComponent::class)
interface ThreadingModule {

    @Binds
    @Singleton
    fun bindsThread(thread: DefaultThread): Thread
}