package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import com.muammarahlnn.lsv.core.util.addSlidingAnim
import com.muammarahlnn.lsv.core.util.createRoute
import com.muammarahlnn.lsv.core.util.navigateRoute

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ResourceDetailsNavigation, 23/05/2024 15.40
 */
private const val RESOURCE_DETAILS_ROUTE = "resource_details"
const val RESOURCE_ID_ARG = "resource_id"
const val RESOURCE_TYPE_ORDINAL_ARG = "resource_type_ordinal"
val RESOURCE_DETAILS_FULL_ROUTE = createRoute(
    RESOURCE_DETAILS_ROUTE,
    RESOURCE_ID_ARG,
    RESOURCE_TYPE_ORDINAL_ARG
)

fun NavController.navigateToResourceDetails(
    resourceId: String,
    resourceTypeOrdinal: Int,
) {
    navigate(
        route = navigateRoute(RESOURCE_DETAILS_ROUTE, resourceId, resourceTypeOrdinal)
    ) {
        addSlidingAnim()
    }
}