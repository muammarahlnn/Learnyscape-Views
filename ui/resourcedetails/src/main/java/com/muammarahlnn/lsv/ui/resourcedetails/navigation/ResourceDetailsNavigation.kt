package com.muammarahlnn.lsv.ui.resourcedetails.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.RESOURCE_DETAILS_FULL_ROUTE
import com.muammarahlnn.lsv.core.navigation.RESOURCE_ID_ARG
import com.muammarahlnn.lsv.core.navigation.RESOURCE_TYPE_ORDINAL_ARG
import com.muammarahlnn.lsv.ui.resourcedetails.ResourceDetailsFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsNavigation, 23/05/2024 15.40
 */
fun NavGraphBuilder.resourceDetailsFragment() {
    fragment<ResourceDetailsFragment>(RESOURCE_DETAILS_FULL_ROUTE) {
        label = "Resource Details"
        argument(RESOURCE_ID_ARG) {
            type = NavType.StringType
        }
        argument(RESOURCE_TYPE_ORDINAL_ARG) {
            type = NavType.IntType
        }
    }
}