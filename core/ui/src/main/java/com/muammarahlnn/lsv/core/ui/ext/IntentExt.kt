package com.muammarahlnn.lsv.core.ui.ext

import android.content.Intent
import android.os.Build
import java.io.Serializable

/**
 * @Author Muammar Ahlan Abimanyu
 * @File IntentExt, 10/05/2024 01.37
 */

inline fun <reified T: Serializable> Intent.serializableExtra(key: String): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getSerializableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getSerializableExtra(key) as T?
}