package com.muammarahlnn.lsv.ui.discover.adapter

import android.text.TextUtils
import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.muammarahlnn.lsv.core.model.AvailableClassModel
import com.muammarahlnn.lsv.core.ui.ext.hide
import com.muammarahlnn.lsv.core.ui.ext.show
import com.muammarahlnn.lsv.core.ui.util.toDisplayedTime
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.discover.databinding.ItemAvailableClassBinding
import com.muammarahlnn.lsv.core.ui.R as uiR


/**
 * @Author Muammar Ahlan Abimanyu
 * @File AvailableClassViewHolder, 14/04/2024 14.11
 */
internal class AvailableClassViewHolder(
    viewBinding: ItemAvailableClassBinding,
    private val onItemClickListener: (AvailableClassModel) -> Unit,
) : BaseViewHolder<ItemAvailableClassBinding, AvailableClassModel>(viewBinding) {

    override fun render(state: AvailableClassModel) {
        viewBinding.root.also { view ->
            view.setOnClickListener {
                onItemClickListener(state)
            }
        }

        viewBinding.tvClassName.also { view ->
            view.text = state.name
        }

        viewBinding.llLecturers.also { layout ->
            val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            state.lecturers.forEach { lecturer ->
                val tvLecturer = TextView(context).apply {
                    this.layoutParams = layoutParams
                    text = lecturer.fullName
                    textSize = 10f
                    setTextColor(ContextCompat.getColor(context, uiR.color.gray))
                    typeface = ResourcesCompat.getFont(context, uiR.font.poppins_medium)
                    isSingleLine = true
                    ellipsize = TextUtils.TruncateAt.END
                }
                layout.addView(tvLecturer)
            }
        }

        viewBinding.tvSchedule.also { view ->
            val day = state.day.displayedText
            val startTime = state.startTime.toDisplayedTime()
            val endTime = state.endTime.toDisplayedTime()
            val scheduleText = "$day, $startTime - $endTime"
            view.text = scheduleText
        }

        viewBinding.tvRequested.also { view ->
            if (state.isRequested()) view.show() else view.hide()
        }
    }
}