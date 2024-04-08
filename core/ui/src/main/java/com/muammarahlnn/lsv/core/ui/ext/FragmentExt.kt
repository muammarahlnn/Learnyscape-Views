package com.muammarahlnn.lsv.core.ui.ext

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 * @Author Muammar Ahlan Abimanyu
 * @File FragmentExt, 08/03/2024 22.52
 */
val Fragment.screenHeight: Int
    get() = activity?.resources?.displayMetrics?.heightPixels ?: 0

fun Fragment.readDrawable(@DrawableRes resId: Int): Drawable =
    requireContext().readDrawable(resId)

fun Fragment.readText(@StringRes resId: Int, vararg formatArgs: Any): String =
    requireContext().readText(resId, formatArgs)

fun Fragment.readColor(@ColorRes resId: Int): Int =
    requireContext().readColor(resId)

fun Fragment.findNavController(@IdRes id: Int): NavController {
    var parent = parentFragment
    while (parent != null) {
        if (parent is NavHostFragment && parent.id == id) {
            return parent.navController
        }
        parent = parent.parentFragment
    }
    throw RuntimeException("NavController with specified id not found.")
}