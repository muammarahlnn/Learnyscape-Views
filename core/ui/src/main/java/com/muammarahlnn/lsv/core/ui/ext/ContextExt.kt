package com.muammarahlnn.lsv.core.ui.ext

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ContextExt, 08/03/2024 22.54
 */
fun Context.readDrawable(@DrawableRes resId: Int): Drawable = drawable(resId)

fun Context.readText(@StringRes resId: Int, vararg formatArgs: Any): String =
    getString(resId, *formatArgs)

fun Context.readColor(@ColorRes resId: Int): Int = ContextCompat.getColor(this, resId)

fun Context.readFont(@FontRes resId: Int): Typeface? = ResourcesCompat.getFont(this, resId)

fun Context.dpToPx(dp: Int): Int = (dp * resources.displayMetrics.density).toInt()

fun Context.pxToDp(px: Int): Int = (px / resources.displayMetrics.density).toInt()

fun Context.dpToPx(dp: Float): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)