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

package com.jpaya.englishisfun.idioms.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.transition.TransitionManager
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import com.jpaya.englishisfun.R
import com.jpaya.base.ui.searchview.DebouncingQueryTextListener
import com.jpaya.englishisfun.extensions.hide
import com.jpaya.englishisfun.extensions.show
import com.jpaya.englishisfun.idioms.ui.adapter.IdiomsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.idioms_fragment_list.*

@AndroidEntryPoint
class IdiomsListFragment : RainbowCakeFragment<ListViewState, IdiomsListViewModel>() {

    private val customViewModel: IdiomsListViewModel by viewModels()
    private lateinit var idiomsAdapter: IdiomsAdapter

    override fun provideViewModel() = customViewModel
    override fun getViewResource() = R.layout.idioms_fragment_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idiomsAdapter = IdiomsAdapter()
        idiomsList.adapter = idiomsAdapter
        idiomsList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        retryButton.setOnClickListener {
            viewModel.reload()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search, menu)

        (menu.findItem(R.id.action_search).actionView as SearchView).apply {
            queryHint = getString(R.string.search)
            setOnQueryTextListener(
                DebouncingQueryTextListener(this@IdiomsListFragment) {
                    if (it == null || it.isEmpty()) {
                        viewModel.resetSearch()
                    } else {
                        viewModel.search(it)
                    }
                }
            )
            clearFocus()
        }
    }

    override fun render(viewState: ListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        when (viewState) {
            Loading -> {
                shimmerLayout.show()
                idiomsList.isVisible = false
                errorGroup.isVisible = false
            }
            is ListReady -> {
                idiomsAdapter.submitList(viewState.idioms)
                shimmerLayout.hide()
                idiomsList.isVisible = true
                errorGroup.isVisible = false
            }
            NetworkError -> {
                idiomsAdapter.submitList(null)
                shimmerLayout.hide()
                idiomsList.isVisible = false
                errorGroup.isVisible = true
            }
        }.exhaustive
    }
}
