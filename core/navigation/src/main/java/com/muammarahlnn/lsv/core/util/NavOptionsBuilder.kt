package com.muammarahlnn.lsv.core.util

import androidx.navigation.NavOptionsBuilder
import com.muammarahlnn.lsv.core.navigation.R

/**
 * @Author Muammar Ahlan Abimanyu
 * @File NavBuilder, 08/04/2024 02.42
 */
fun NavOptionsBuilder.addSlidingAnim() {
    anim {
        enter = R.anim.slide_in_left
        exit = R.anim.slide_out_left
        popEnter = R.anim.slide_in_right
        popExit = R.anim.slide_out_right
    }
}