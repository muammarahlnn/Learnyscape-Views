package com.muammarahlnn.core.ui.ext

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DrawableExt, 08/03/2024 22.55
 */
fun Context.drawable(@DrawableRes resId: Int): Drawable {
    val drawable = ContextCompat.getDrawable(this, resId)
    return drawable ?: ColorDrawable()
}