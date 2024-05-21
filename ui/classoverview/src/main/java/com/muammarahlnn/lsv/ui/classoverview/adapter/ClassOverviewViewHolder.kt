package com.muammarahlnn.lsv.ui.classoverview.adapter

import com.muammarahlnn.lsv.core.model.ClassResourceOverviewModel
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.ASSIGNMENT
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.MODULE
import com.muammarahlnn.lsv.core.navigation.ClassOverviewScreen.QUIZ
import com.muammarahlnn.lsv.core.ui.ext.readDrawable
import com.muammarahlnn.lsv.core.ui.ext.readText
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.classoverview.R
import com.muammarahlnn.lsv.ui.classoverview.databinding.ItemClassOverviewBinding
import com.muammarahlnn.lsv.core.ui.R as uiR

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassOverviewViewHolder, 20/05/2024 01.33
 */
internal class ClassOverviewViewHolder(
    viewBinding: ItemClassOverviewBinding,
    private val classOverviewScreen: ClassOverviewScreen,
    private val onItemClickListener: (ClassResourceOverviewModel) -> Unit,
) : BaseViewHolder<ItemClassOverviewBinding, ClassResourceOverviewModel>(viewBinding){

    override fun render(state: ClassResourceOverviewModel) {
        viewBinding.root.also { view ->
            view.setOnClickListener {
                onItemClickListener(state)
            }
        }

        viewBinding.ivResourceType.also { view ->
            view.setImageDrawable(
                context.readDrawable(
                    when (classOverviewScreen) {
                        MODULE -> uiR.drawable.ic_book
                        ASSIGNMENT -> uiR.drawable.ic_assignment
                        QUIZ -> uiR.drawable.ic_quiz
                    }
                )
            )
        }

        viewBinding.tvName.also { view ->
            view.text = state.name
        }

        viewBinding.tvDesc.also { view ->
            view.text = context.readText(
                when (classOverviewScreen) {
                    MODULE -> R.string.module_desc
                    ASSIGNMENT -> R.string.assignment_desc
                    QUIZ -> R.string.quiz_desc
                },
                state.date
            )
        }
    }
}