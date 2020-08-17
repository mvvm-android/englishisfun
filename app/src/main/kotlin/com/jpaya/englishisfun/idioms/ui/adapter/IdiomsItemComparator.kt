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

package com.jpaya.englishisfun.idioms.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jpaya.englishisfun.idioms.ui.IdiomsListPresenter.IdiomsItem

object IdiomsItemComparator : DiffUtil.ItemCallback<IdiomsItem>() {
    override fun areItemsTheSame(oldItem: IdiomsItem, newItem: IdiomsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: IdiomsItem, newItem: IdiomsItem): Boolean {
        return oldItem == newItem
    }
}
