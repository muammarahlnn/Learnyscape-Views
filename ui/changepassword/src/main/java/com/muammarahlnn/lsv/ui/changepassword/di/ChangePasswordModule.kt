package com.muammarahlnn.lsv.ui.changepassword.di

import com.muammarahlnn.lsv.ui.changepassword.ChangePasswordUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePasswordModule, 29/04/2024 19.45
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object ChangePasswordModule {

    @Provides
    fun providesState(): ChangePasswordUiState = ChangePasswordUiState.None
}