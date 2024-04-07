package com.muammarahlnn.lsv.core.ui.ext

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * @Author Muammar Ahlan Abimanyu
 * @File SoftKeyboardExt, 08/04/2024 03.34
 */
fun View.showSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, 0)
}

fun View.hideSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}