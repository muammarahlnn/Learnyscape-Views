package com.muammarahlnn.lsv.ui.pendingrequest.di

import com.muammarahlnn.lsv.ui.pendingrequest.PendingRequestUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestModule, 21/04/2024 03.01
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object PendingRequestModule {

    @Provides
    fun providesUiState(): PendingRequestUiState = PendingRequestUiState.OnFetchPendingRequests(true)
}