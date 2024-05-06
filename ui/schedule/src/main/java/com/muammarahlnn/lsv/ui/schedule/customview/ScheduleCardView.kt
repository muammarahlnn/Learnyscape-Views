package com.muammarahlnn.lsv.ui.schedule.customview

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.BOTTOM
import androidx.constraintlayout.widget.ConstraintSet.PARENT_ID
import androidx.constraintlayout.widget.ConstraintSet.START
import androidx.constraintlayout.widget.ConstraintSet.TOP
import com.google.android.material.card.MaterialCardView
import com.muammarahlnn.lsv.core.model.ScheduleModel
import com.muammarahlnn.lsv.core.ui.ext.dpToPx
import com.muammarahlnn.lsv.core.ui.ext.readColor
import com.muammarahlnn.lsv.core.ui.ext.readFont
import kotlinx.datetime.LocalTime
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ScheduleCardView, 05/05/2024 15.59
 */
class ScheduleCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val parentConstraint: ConstraintLayout by lazy { ConstraintLayout(context) }

    private val constraintSet: ConstraintSet by lazy { ConstraintSet() }

    private val tvClassName = TextView(context).apply {
        id = generateViewId()
        layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        setTextColor(context.readColor(uiR.color.black))
        typeface = context.readFont(uiR.font.poppins_medium)
    }

    private val tvClassTime = TextView(context).apply {
        id = generateViewId()
        layoutParams = LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
        setTextColor(context.readColor(uiR.color.black))
        typeface = context.readFont(uiR.font.poppins_regular)
    }

    private lateinit var schedule: ScheduleModel

    init {
        createView()
    }

    private fun createView() {
        setupCardView()
        addParentLayout()
        addChildViews()
    }

    private fun setupCardView() {
        radius = context.dpToPx(8f)
        elevation = context.dpToPx(2f)
    }

    private fun addParentLayout() {
        parentConstraint.apply {
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
            setBackgroundColor(context.readColor(uiR.color.white))
        }
        addView(parentConstraint)
    }

    private fun addChildViews() {
        parentConstraint.addView(tvClassName)
        parentConstraint.addView(tvClassTime)

        constraintSet.apply {
            clone(parentConstraint)

            connect(tvClassName.id, TOP, PARENT_ID, TOP, context.dpToPx(8))
            connect(tvClassName.id, START, PARENT_ID, START, context.dpToPx(16))

            connect(tvClassTime.id, TOP, tvClassName.id, BOTTOM)
            connect(tvClassTime.id, START, tvClassName.id, START)

            applyTo(parentConstraint)
        }
    }

    fun setSchedule(schedule: ScheduleModel) {
        this.schedule = schedule
        updateData()
    }

    fun setOnScheduleClickListener(listener: (className: String) -> Unit) {
        if (::schedule.isInitialized) {
            setOnClickListener {
                listener(schedule.className)
            }
        }
    }

    private fun updateData() {
        tvClassName.text = schedule.className
        tvClassTime.text = formatStartEndTime(
            startTime = schedule.startTime,
            endTime = schedule.endTime,
        )
    }

    private fun formatStartEndTime(startTime: LocalTime, endTime: LocalTime): String {
        val format = "%02d:%02d"
        val formattedStartTime = String.format(format, startTime.hour, startTime.minute)
        val formattedEndTime = String.format(format, endTime.hour, endTime.minute)
        return "$formattedStartTime - $formattedEndTime"
    }
}