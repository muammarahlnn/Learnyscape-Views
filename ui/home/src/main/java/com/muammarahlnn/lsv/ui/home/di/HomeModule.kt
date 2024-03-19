package com.muammarahlnn.lsv.ui.home.di

import com.muammarahlnn.lsv.ui.home.HomeState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeModule, 19/03/2024 02.35
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object HomeModule {

    @Provides
    fun providesState(): HomeState = HomeState()
}