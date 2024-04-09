package com.muammarahlnn.lsv.ui.home.adapter

import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.muammarahlnn.lsv.core.model.EnrolledClassModel
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.home.databinding.ItemClassBinding
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassViewHolder, 24/03/2024 03.44
 */
internal class ClassViewHolder(
    viewBinding: ItemClassBinding,
    private val onItemClickListener: (EnrolledClassModel) -> Unit,
) : BaseViewHolder<ItemClassBinding, EnrolledClassModel>(viewBinding) {

    override fun render(state: EnrolledClassModel) {
        viewBinding.root.also { view ->
            view.setOnClickListener {
                onItemClickListener(state)
            }
        }

        viewBinding.tvClassName.also { view ->
            view.text = state.className
        }

        viewBinding.llLecturers.also { layout ->
            val layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            state.lecturerNames.forEach { lecturerName ->
                val tvLecturer = TextView(context).apply {
                    this.layoutParams = layoutParams
                    text = lecturerName
                    textSize = 13f
                    typeface = ResourcesCompat.getFont(context, uiR.font.poppins_regular)
                }
                layout.addView(tvLecturer)
            }
        }
    }
}