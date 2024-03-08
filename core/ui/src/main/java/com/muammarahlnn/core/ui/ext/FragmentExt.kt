package com.muammarahlnn.core.ui.ext

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File FragmentExt, 08/03/2024 22.52
 */
fun Fragment.readDrawable(@DrawableRes resId: Int): Drawable =
    requireContext().readDrawable(resId)

fun Fragment.readText(@StringRes resId: Int, vararg formatArgs: Any): String =
    requireContext().readText(resId, formatArgs)