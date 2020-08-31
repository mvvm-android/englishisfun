package com.jpaya.englishisfun.abbreviations.ui.model

import androidx.recyclerview.widget.DiffUtil

data class AbbreviationItem(
    val id: Long,
    val abbr: String,
    val desc: String
) {

    companion object {
        object COMPARATOR : DiffUtil.ItemCallback<AbbreviationItem>() {
            override fun areItemsTheSame(oldItem: AbbreviationItem, newItem: AbbreviationItem) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: AbbreviationItem, newItem: AbbreviationItem) = oldItem == newItem
        }
    }
}
