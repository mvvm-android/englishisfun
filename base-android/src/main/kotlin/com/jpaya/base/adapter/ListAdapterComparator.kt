package com.jpaya.base.adapter

import androidx.recyclerview.widget.DiffUtil

class ListAdapterComparator<T : GenericAdapterComparator<T>> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.isSameItemAs(newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.hasSameContentsAs(newItem)
}
