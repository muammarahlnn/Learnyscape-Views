package com.muammarahlnn.lsv.ui.schedule.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.VERTICAL
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.BOTTOM
import androidx.constraintlayout.widget.ConstraintSet.END
import androidx.constraintlayout.widget.ConstraintSet.PARENT_ID
import androidx.constraintlayout.widget.ConstraintSet.START
import androidx.constraintlayout.widget.ConstraintSet.TOP
import androidx.constraintlayout.widget.Guideline
import com.muammarahlnn.lsv.core.model.ScheduleModel
import com.muammarahlnn.lsv.core.ui.ext.dpToPx
import com.muammarahlnn.lsv.core.ui.ext.readColor
import com.muammarahlnn.lsv.core.ui.ext.readFont
import kotlinx.datetime.LocalTime
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleCalendarView, 05/05/2024 01.36
 */
class ScheduleCalendarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val constraintSet: ConstraintSet by lazy { ConstraintSet() }

    private val schedules = mutableListOf<ScheduleModel>()

    private val hourTextViewMap = mutableMapOf<Int, TextView>()

    init {
        createView()
    }

    private fun createView() {
        createScheduleHours()
    }

    private fun createScheduleHours() {
        val guideline = Guideline(context).apply {
            id = Guideline.generateViewId()
            layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                orientation = VERTICAL
            }
            setGuidelinePercent(0.15f)
        }
        addView(guideline)

        var previousTvHourId = 0
        val scheduleHours = 7..23
        scheduleHours.forEachIndexed { index, hour ->
            val tvHour = TextView(context).apply {
                id = View.generateViewId()
                layoutParams = LayoutParams(WRAP_CONTENT, dpToPx(HOUR_TEXT_VIEW_HEIGHT))
                text = formatHourToDisplayedText(hour)
                textSize = 15f
                setTextColor(context.readColor(uiR.color.black))
                typeface = context.readFont(uiR.font.poppins_medium)
            }.also {
                addView(it)
                hourTextViewMap[hour] = it
            }

            constraintSet.apply {
                clone(this@ScheduleCalendarView)

                connect(tvHour.id, END, guideline.id, START)
                if (index == 0) {
                    connect(tvHour.id, TOP, PARENT_ID, TOP, dpToPx(16))
                } else {
                    connect(tvHour.id, TOP, previousTvHourId, BOTTOM)
                }

                applyTo(this@ScheduleCalendarView)
            }

            previousTvHourId = tvHour.id
        }
    }

    fun setupSchedules(
        schedules: List<ScheduleModel>,
        onScheduleClickListener: (String) -> Unit,
    ) {
        this.schedules.apply {
            clear()
            addAll(schedules)
        }
        createScheduleCards(onScheduleClickListener)
    }

    private fun createScheduleCards(onScheduleClickListener: (String) -> Unit) {
        val guideline = Guideline(context).apply {
            id = Guideline.generateViewId()
            layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
                orientation = VERTICAL
            }
            setGuidelineEnd(dpToPx(16))
        }
        addView(guideline)

        schedules.forEach { schedule ->
            val startTimeTvHour = hourTextViewMap.getValue(schedule.startTime.hour)
            val marginTop = Math.round((schedule.startTime.minute / 60f) * HOUR_TEXT_VIEW_HEIGHT)
            val scheduleCard = ScheduleCardView(context).apply {
                id = generateViewId()
                layoutParams = LayoutParams(
                    MATCH_CONSTRAINT,
                    dpToPx(calculateScheduleCardHeight(schedule))
                ).apply {
                    topToTop = startTimeTvHour.id
                    startToEnd = startTimeTvHour.id
                    endToEnd = guideline.id

                    topMargin = dpToPx(marginTop)
                    marginStart = dpToPx(16)
                }
                setSchedule(schedule)
                setOnScheduleClickListener(onScheduleClickListener)
            }
            addView(scheduleCard)
        }
    }

    private fun calculateScheduleCardHeight(schedule: ScheduleModel): Int {
        val durationInMinute = getScheduleDurationInMinute(schedule.startTime, schedule.endTime)
        val hour = durationInMinute / 60
        val minute = durationInMinute % 60
        val totalHeight = (hour * HOUR_TEXT_VIEW_HEIGHT) + ((minute / 60f) * HOUR_TEXT_VIEW_HEIGHT)
        return Math.round(totalHeight)
    }

    private fun getScheduleDurationInMinute(
        startTime: LocalTime,
        endTime: LocalTime,
    ): Int {
        fun LocalTime.inMinute(): Int = (hour * 60) + minute
        return endTime.inMinute() - startTime.inMinute()
    }

    private fun formatHourToDisplayedText(hour: Int): String = String.format("%02d:00", hour)

    private fun dpToPx(dp: Int): Int = context.dpToPx(dp)

    private companion object {

        const val HOUR_TEXT_VIEW_HEIGHT = 100
    }
}