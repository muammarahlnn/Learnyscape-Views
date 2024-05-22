package com.muammarahlnn.lsv.ui.resourcedetails

import com.muammarahlnn.lsv.core.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsViewModel, 22/05/2024 21.07
 */
@HiltViewModel
internal class ResourceDetailsViewModel @Inject constructor(
    initialState: ResourceDetailsState,
) : BaseViewModel<ResourceDetailsState>(initialState)