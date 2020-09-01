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

package com.jpaya.englishisfun.statives.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.transition.TransitionManager
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import com.jpaya.englishisfun.R
import com.jpaya.englishisfun.extensions.hide
import com.jpaya.englishisfun.extensions.show
import com.jpaya.englishisfun.statives.ui.adapter.StativesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.stative_fragment_list.*

@AndroidEntryPoint
class StativesFragment : RainbowCakeFragment<ListViewState, StativesViewModel>() {

    private val customViewModel: StativesViewModel by viewModels()
    private lateinit var adapter: StativesAdapter

    override fun provideViewModel() = customViewModel
    override fun getViewResource() = R.layout.stative_fragment_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StativesAdapter()
        list.adapter = adapter
        list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        retryButton.setOnClickListener {
            viewModel.reload()
        }
        viewSavedButton.setOnClickListener {
//            navigator?.add(SavedFragment())
        }
    }

    override fun render(viewState: ListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        when (viewState) {
            Loading -> {
                shimmerLayout.show()
                list.isVisible = false
                errorGroup.isVisible = false
            }
            is ListReady -> {
                adapter.submitList(viewState.items)
                shimmerLayout.hide()
                list.isVisible = true
                errorGroup.isVisible = false
            }
            NetworkError -> {
                adapter.submitList(null)
                shimmerLayout.hide()
                list.isVisible = false
                errorGroup.isVisible = true
            }
        }.exhaustive
    }
}
