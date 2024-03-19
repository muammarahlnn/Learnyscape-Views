package com.muammarahlnn.lsv.ui.discover.di

import com.muammarahlnn.lsv.ui.discover.DiscoverState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DiscoverModule, 19/03/2024 02.21
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object DiscoverModule {

    @Provides
    fun providesState(): DiscoverState = DiscoverState()
}