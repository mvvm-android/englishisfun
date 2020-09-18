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

package com.jpaya.englishisfun.abbreviations.ui.adapter

import android.animation.AnimatorInflater
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jpaya.base.adapter.ListAdapterComparator
import com.jpaya.base.ui.bindings.visible
import com.jpaya.englishisfun.DataBindingAdapter
import com.jpaya.englishisfun.R
import com.jpaya.englishisfun.abbreviations.ui.model.AbbreviationItem
import com.jpaya.englishisfun.databinding.AbbreviationsListItemBinding
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView

class AbbreviationsAdapter :
    ListAdapter<AbbreviationItem, AbbreviationsAdapter.ViewHolder>(ListAdapterComparator<AbbreviationItem>()),
    FastScrollRecyclerView.SectionedAdapter,
    DataBindingAdapter<List<AbbreviationItem>> {

    companion object {
        private const val TRANSITION_DURATION = 500
    }

    override fun setData(data: List<AbbreviationItem>) = submitList(data)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(AbbreviationsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    override fun getSectionName(position: Int): String = getItem(position).abbr.first().toString()

    class ViewHolder(val binding: AbbreviationsListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AbbreviationItem) {
            itemView.setOnClickListener {
                binding.abbreviation?.let {
                    it.open = it.open.not()
                    AnimatorInflater.loadAnimator(itemView.context, R.animator.flip).apply {
                        setTarget(itemView)
                        start()
                    }
                    binding.tvAbbreviation.visible = it.open.not()
                    binding.tvDescription.visible = it.open
                    val trans = TransitionDrawable(
                        if (it.open) {
                            arrayOf(ColorDrawable(Color.WHITE), ColorDrawable(Color.BLACK))
                        } else {
                            arrayOf(ColorDrawable(Color.BLACK), ColorDrawable(Color.WHITE))
                        }
                    )
                    itemView.background = trans
                    trans.startTransition(TRANSITION_DURATION)
                }
            }
            binding.abbreviation = item
            binding.executePendingBindings()
        }
    }
}
