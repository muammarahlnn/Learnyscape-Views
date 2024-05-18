package com.muammarahlnn.lsv.ui.classoverview.di

import com.muammarahlnn.lsv.ui.classoverview.ClassOverviewState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewState, 12/05/2024 02.50
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object ClassOverviewModule {

    @Provides
    fun providesState(): ClassOverviewState = ClassOverviewState()
}