package com.muammarahlnn.lsv.ui.homenavigator.di

import com.muammarahlnn.lsv.ui.homenavigator.HomeNavigatorState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File HomeNavigatorModule, 19/03/2024 03.25
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object HomeNavigatorModule {

    @Provides
    fun providesState(): HomeNavigatorState = HomeNavigatorState()

}