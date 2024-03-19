package com.muammarahlnn.lsv.ui.schedule.di

import com.muammarahlnn.lsv.ui.schedule.ScheduleState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleModule, 19/03/2024 02.41
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object ScheduleModule {

    @Provides
    fun providesState(): ScheduleState = ScheduleState()
}