package com.muammarahlnn.lsv.ui.classnavigator.di

import com.muammarahlnn.lsv.ui.classnavigator.ClassNavigatorState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassNavigatorModule, 17/05/2024 16.09
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object ClassNavigatorModule {

    @Provides
    fun providesState(): ClassNavigatorState = ClassNavigatorState()
}