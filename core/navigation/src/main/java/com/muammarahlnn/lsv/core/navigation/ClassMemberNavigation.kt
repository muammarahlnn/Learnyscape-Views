package com.muammarahlnn.lsv.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.muammarahlnn.lsv.core.util.createRoute
import com.muammarahlnn.lsv.core.util.navigateRoute

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberNavigation, 12/05/2024 00.45
 */
private const val CLASS_MEMBER_ROUTE = "class_member"
val CLASS_MEMBER_FULL_ROUTE = createRoute(
    CLASS_MEMBER_ROUTE,
    CLASS_ID_ARG,
)

fun NavController.navigateToClassMember(
    classId: String,
    navOptions: NavOptions? = null
) {
    navigate(
        route = navigateRoute(CLASS_MEMBER_ROUTE, classId),
        navOptions = navOptions,
    )
}