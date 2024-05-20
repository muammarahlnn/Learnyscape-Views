package com.muammarahlnn.lsv.ui.classmember.adapter

import com.muammarahlnn.lsv.core.model.ClassMembersModel
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.classmember.databinding.ItemClassMemberBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberViewHolder, 20/05/2024 21.01
 */
internal class ClassMemberViewHolder(
    viewBinding: ItemClassMemberBinding,
) : BaseViewHolder<ItemClassMemberBinding, ClassMembersModel.Member>(viewBinding) {

    override fun render(state: ClassMembersModel.Member) {
        viewBinding.tvName.also { view ->
            view.text = state.name
        }
    }
}