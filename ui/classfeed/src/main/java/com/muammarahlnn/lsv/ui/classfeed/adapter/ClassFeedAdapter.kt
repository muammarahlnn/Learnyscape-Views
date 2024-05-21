package com.muammarahlnn.lsv.ui.classfeed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muammarahlnn.lsv.core.model.ClassFeedModel
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.ANNOUNCEMENT
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.ASSIGNMENT
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.MODULE
import com.muammarahlnn.lsv.core.model.ClassResourceTypeModel.QUIZ
import com.muammarahlnn.lsv.core.ui.widget.viewholder.BaseViewHolder
import com.muammarahlnn.lsv.ui.classfeed.databinding.ItemFeedAnnouncementBinding
import com.muammarahlnn.lsv.ui.classfeed.databinding.ItemFeedResourceBinding

/**
 * @Author Muammar Ahlan Abimanyu
 * @File ClassFeedAdapter, 21/05/2024 19.14
 */
internal class ClassFeedAdapter(
    private val onItemClickListener: (ClassFeedModel) -> Unit,
) : RecyclerView.Adapter<BaseViewHolder<*, ClassFeedModel>>() {

    private val feeds = mutableListOf<ClassFeedModel>()

    fun setFeeds(feeds: List<ClassFeedModel>) {
        this.feeds.apply {
            clear()
            addAll(feeds)
        }
        notifyItemRangeChanged(0, this.feeds.size)
    }

    override fun getItemCount(): Int = feeds.size

    override fun getItemViewType(position: Int): Int = feeds[position].type.ordinal

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, ClassFeedModel> = when (viewType) {
        ANNOUNCEMENT.ordinal -> AnnouncementFeedViewHolder(
            ItemFeedAnnouncementBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClickListener
        )

        MODULE.ordinal,
        ASSIGNMENT.ordinal,
        QUIZ.ordinal -> ResourceFeedViewHolder(
            ItemFeedResourceBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClickListener
        )

        else -> throw IllegalArgumentException()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*, ClassFeedModel>, position: Int) {
        holder.render(feeds[position])
    }
}