package com.muammarahlnn.lsv.ui.pendingrequest.adapter

import android.view.ViewGroup.LayoutParams
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.muammarahlnn.lsv.core.model.PendingRequestModel
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.pendingrequest.databinding.ItemPendingRequestBinding
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File PendingRequestViewHolder, 21/04/2024 04.05
 */
internal class PendingRequestViewHolder(
    viewBinding: ItemPendingRequestBinding,
    private val onItemClickListener: (PendingRequestModel) -> Unit,
) : BaseViewHolder<ItemPendingRequestBinding, PendingRequestModel>(viewBinding) {

    override fun render(state: PendingRequestModel) {
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
            state.lecturers.forEach { lecturer ->
                val tvLecturer = TextView(context).apply {
                    this.layoutParams = layoutParams
                    text = lecturer
                    textSize = 12f
                    typeface = ResourcesCompat.getFont(context, uiR.font.poppins_regular)
                }
                layout.addView(tvLecturer)
            }
        }
    }
}