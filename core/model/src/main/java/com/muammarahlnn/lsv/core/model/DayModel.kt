package com.muammarahlnn.lsv.core.model

/**
 * @Author Muammar Ahlan Abimanyu
 * @File DayModel, 14/04/2024 13.33
 */
enum class DayModel(val displayedText: String) {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    companion object {

        private val dayLookup by lazy {
            entries.associateBy { it.name }
        }

        fun fromDayName(dayName: String): DayModel = dayLookup[dayName]
            ?: throw IllegalArgumentException("The given day not matched any DayModel")
    }
}