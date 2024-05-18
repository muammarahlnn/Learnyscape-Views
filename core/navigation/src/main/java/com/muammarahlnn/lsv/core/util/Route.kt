package com.muammarahlnn.lsv.core.util

/**
 * @Author Muammar Ahlan Abimanyu
 * @File Route, 12/05/2024 00.51
 */

fun createRoute(route: String, vararg arguments: String): String = buildString {
    append(route)
    arguments.forEach { argument ->
        append("/{$argument}")
    }
}

fun navigateRoute(route: String, vararg arguments: Any): String = buildString {
    append(route)
    arguments.forEach { argument ->
        append("/$argument")
    }
}