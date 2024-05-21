package com.muammarahlnn.lsv.ui.classfeed.di

import com.muammarahlnn.lsv.ui.classfeed.ClassFeedUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedModule, 12/05/2024 02.45
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object ClassFeedModule {

    @Provides
    fun providesState(): ClassFeedUiState = ClassFeedUiState.LoadingFetchDetails(true)
}