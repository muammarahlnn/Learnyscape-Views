package com.muammarahlnn.lsv.ui.assignmentsubmission.di

import com.muammarahlnn.lsv.ui.assignmentsubmission.AssignmentSubmissionState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

/**
 * @Author Muammar Ahlan Abimanyu
 * @File AssignmentSubmissionModule, 05/06/2024 02.24
 */
@Module
@InstallIn(ViewModelComponent::class, FragmentComponent::class)
object AssignmentSubmissionModule {

    @Provides
    fun providesState(): AssignmentSubmissionState = AssignmentSubmissionState()
}