package com.muammarahlnn.lsv.ui.classmember.di

import com.muammarahlnn.lsv.ui.classmember.ClassMemberUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberModule, 12/05/2024 02.48
 */
@Module
@InstallIn(FragmentComponent::class, ViewModelComponent::class)
internal object ClassMemberModule {

    @Provides
    fun providesState(): ClassMemberUiState = ClassMemberUiState.Loading(true)
}