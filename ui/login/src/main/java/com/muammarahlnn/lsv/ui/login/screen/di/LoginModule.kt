package com.muammarahlnn.lsv.ui.login.screen.di

import com.muammarahlnn.lsv.ui.login.screen.LoginState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LoginModule, 18/03/2024 01.13
 */
@Module
@InstallIn(ViewModelComponent::class, FragmentComponent::class)
internal object LoginModule {

    @Provides
    fun providesState(): LoginState = LoginState()
}