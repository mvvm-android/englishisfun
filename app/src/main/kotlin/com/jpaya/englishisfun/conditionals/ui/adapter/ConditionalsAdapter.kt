/*
 * Copyright 2020 Jose Maria Payá Castillo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jpaya.englishisfun.conditionals.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jpaya.englishisfun.conditionals.ui.ConditionalsListPresenter.ConditionalsItem
import com.jpaya.englishisfun.databinding.ConditionalsListItemBinding
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView

class ConditionalsAdapter(private val listener: Listener) :
    ListAdapter<ConditionalsItem, ConditionalsAdapter.ViewHolder>(ConditionalsItemComparator),
    FastScrollRecyclerView.SectionedAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ConditionalsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    override fun getSectionName(position: Int): String = getItem(position).base.first().toString()

    inner class ViewHolder(private var binding: ConditionalsListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ConditionalsItem) {
            itemView.setOnClickListener {
                binding.irregular?.let { listener.onItemSelected(it.id) }
            }
            binding.irregular = item
            binding.executePendingBindings()
        }
    }

    interface Listener {
        fun onItemSelected(id: Long)
    }
}
