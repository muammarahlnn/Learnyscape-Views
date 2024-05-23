package com.muammarahlnn.lsv.ui.resourcedetails.di

import com.muammarahlnn.lsv.ui.resourcedetails.ResourceDetailsUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsModule, 22/05/2024 21.08
 */
@Module
@InstallIn(ViewModelComponent::class, FragmentComponent::class)
internal object ResourceDetailsModule {

    @Provides
    fun providesState(): ResourceDetailsUiState = ResourceDetailsUiState.LoadingFetchDetails(true)
}