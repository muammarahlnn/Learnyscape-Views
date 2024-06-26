package com.muammarahlnn.lsv.ui.profile.di

import com.muammarahlnn.lsv.ui.profile.ProfileUiState
import com.muammarahlnn.lsv.ui.profile.sheet.ChangePhotoProfileState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ProfileModule, 19/03/2024 02.38
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object ProfileModule {

    @Provides
    fun providesState(): ProfileUiState = ProfileUiState.None

    @Provides
    fun providesChangePhotoProfileState(): ChangePhotoProfileState = ChangePhotoProfileState()
}