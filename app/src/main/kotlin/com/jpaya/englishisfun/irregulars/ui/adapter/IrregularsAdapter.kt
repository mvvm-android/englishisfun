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

package com.jpaya.englishisfun.irregulars.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jpaya.englishisfun.irregulars.ui.IrregularsListPresenter.IrregularsItem
import com.jpaya.englishisfun.R

class IrregularsAdapter : ListAdapter<IrregularsItem, IrregularsAdapter.ViewHolder>(IrregularsItemComparator) {

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.irregulars_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val base: TextView = itemView.findViewById(R.id.base)
        private val simple: TextView = itemView.findViewById(R.id.simple)
        private val participle: TextView = itemView.findViewById(R.id.participle)

        private var irregularsItem: IrregularsItem? = null

        init {
            itemView.setOnClickListener {
                irregularsItem?.let { listener?.onItemSelected(it.id) }
            }
        }

        fun bind(item: IrregularsItem) {
            irregularsItem = item

            base.text = item.base
            simple.text = item.simple
            participle.text = item.participle
        }
    }

    interface Listener {
        fun onItemSelected(id: Long)
    }
}
