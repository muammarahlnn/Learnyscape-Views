package com.muammarahlnn.ui.lsv.notifications.di

import com.muammarahlnn.ui.lsv.notifications.NotificationsUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NotificationsModule, 20/04/2024 17.02
 */
@Module
@InstallIn(ViewModelComponent::class, FragmentComponent::class)
internal object NotificationsModule {

    @Provides
    fun providesUiState(): NotificationsUiState = NotificationsUiState.OnFetchNotifications(true)
}