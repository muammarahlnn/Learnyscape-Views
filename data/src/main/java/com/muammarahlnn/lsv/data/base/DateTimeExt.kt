package com.muammarahlnn.lsv.data.base

import kotlinx.datetime.LocalTime

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DateTimeExt, 14/04/2024 13.43
 */

fun Int.toLocalTime(): LocalTime = LocalTime(
    hour = this / 60,
    minute = this % 60,
)