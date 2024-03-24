package com.muammarahlnn.lsv.ui.home.adapter

import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.home.databinding.ItemClassBinding
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassViewHolder, 24/03/2024 03.44
 */
internal class ClassViewHolder(
    viewBinding: ItemClassBinding,
    private val onItemClickListener: (String) -> Unit,
) : BaseViewHolder<ItemClassBinding, String>(viewBinding) {

    override fun render(state: String) {
        renderContent(state)
    }

    private fun renderContent(className: String) {
        viewBinding.root.also { view ->
            view.setOnClickListener {
                onItemClickListener(className)
            }
        }

        viewBinding.tvClassName.also { view ->
            view.text = className
        }

        val lecturers = listOf("Lorem ipsum dolor", "Ipsum dolor sit amet")
        viewBinding.llLecturers.also { layout ->
            val layoutParams = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            lecturers.forEach { lecturer ->
                val tvLecturer = TextView(context).apply {
                    this.layoutParams = layoutParams
                    text = lecturer
                    textSize = 13f
                    typeface = ResourcesCompat.getFont(context, uiR.font.poppins_regular)
                }
                layout.addView(tvLecturer)
            }
        }
    }
}