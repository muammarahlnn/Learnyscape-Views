package com.muammarahlnn.lsv.core.ui.ext

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ContextExt, 08/03/2024 22.54
 */
fun Context.readDrawable(@DrawableRes resId: Int): Drawable = drawable(resId)

fun Context.readText(@StringRes resId: Int, vararg formatArgs: Any): String =
    getString(resId, *formatArgs)

fun Context.readColor(@ColorRes resId: Int): Int = ContextCompat.getColor(this, resId)