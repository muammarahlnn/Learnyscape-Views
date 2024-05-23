package com.muammarahlnn.lsv.data.base

import kotlinx.datetime.LocalTime
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DateTimeExt, 14/04/2024 13.43
 */
private const val ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
private const val DISPLAY_FORMAT = "d MMM yyyy, HH:mm"

fun Int.toLocalTime(): LocalTime = LocalTime(
    hour = this / 60,
    minute = this % 60,
)

fun String.toStringDateFormatted(): String {
    val isoFormatter = DateTimeFormatter.ofPattern(ISO_DATE_FORMAT)
    val displayFormatter = DateTimeFormatter.ofPattern(DISPLAY_FORMAT)

    val localDateTime = LocalDateTime.parse(this, isoFormatter)
    return localDateTime.format(displayFormatter)
}

fun formatEpochSeconds(epochSeconds: Long): String {
    val displayFormatter = DateTimeFormatter.ofPattern(DISPLAY_FORMAT)
    val localDateTime = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(epochSeconds),
        ZoneId.systemDefault()
    )
    return localDateTime.format(displayFormatter)
}