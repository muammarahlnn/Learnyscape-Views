package com.muammarahlnn.lsv.ui.profile.sheet

import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ChangePhotoProfileViewModel, 07/05/2024 22.28
 */
@HiltViewModel
internal class ChangePhotoProfileViewModel @Inject constructor(
    initialState: ChangePhotoProfileState,
) : BaseViewModel<ChangePhotoProfileState>(initialState)