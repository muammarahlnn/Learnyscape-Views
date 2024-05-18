package com.muammarahlnn.lsv.ui.classmember.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.muammarahlnn.lsv.core.navigation.CLASS_MEMBER_FULL_ROUTE
import com.muammarahlnn.lsv.ui.classmember.ClassMemberFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberNavigation, 12/05/2024 02.49
 */
fun NavGraphBuilder.classMemberFragment() {
    fragment<ClassMemberFragment>(CLASS_MEMBER_FULL_ROUTE) {
        label = "Class Member"
    }
}