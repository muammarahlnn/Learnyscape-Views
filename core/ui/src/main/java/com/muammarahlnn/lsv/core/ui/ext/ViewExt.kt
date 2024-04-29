package com.muammarahlnn.lsv.core.ui.ext

import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ViewExt, 08/04/2024 19.59
 */
fun View.show() {
    visibility = VISIBLE
}

fun View.hide() {
    visibility = GONE
}

fun View.invisible() {
    visibility = INVISIBLE
}
