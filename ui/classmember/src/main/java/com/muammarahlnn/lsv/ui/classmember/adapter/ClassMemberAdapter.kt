package com.muammarahlnn.lsv.ui.classmember.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.muammarahlnn.lsv.core.model.ClassMembersModel
import com.muammarahlnn.lsv.core.ui.widget.adapter.BaseAdapter
import com.muammarahlnn.lsv.ui.classmember.databinding.ItemClassMemberBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassMemberAdapter, 20/05/2024 21.01
 */
internal class ClassMemberAdapter : BaseAdapter<ClassMembersModel.Member, ClassMemberViewHolder>() {

    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ClassMemberViewHolder {
        val viewBinding = ItemClassMemberBinding.inflate(inflater, parent, false)
        return ClassMemberViewHolder(viewBinding)
    }
}