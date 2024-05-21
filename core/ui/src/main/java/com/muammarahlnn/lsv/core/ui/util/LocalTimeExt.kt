package com.muammarahlnn.lsv.core.ui.util

import kotlinx.datetime.LocalTime

/**
 * @Author Muammar Ahlan Abimanyu
 * @File LocalTimeExt, 21/05/2024 17.58
 */
fun LocalTime.toDisplayedTime(): String = String.format("%02d:%02d", hour, minute)