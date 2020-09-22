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
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.transition.TransitionManager
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import com.jpaya.englishisfun.R
import com.jpaya.base.ui.searchview.DebouncingQueryTextListener
import com.jpaya.englishisfun.databinding.IdiomsFragmentListBinding
import com.jpaya.englishisfun.idioms.ui.adapter.IdiomsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.idioms_fragment_list.*

@AndroidEntryPoint
class IdiomsListFragment : RainbowCakeFragment<IdiomsListViewState, IdiomsListViewModel>() {

    private val customViewModel: IdiomsListViewModel by viewModels()
    private lateinit var idiomsAdapter: IdiomsAdapter
    private lateinit var binding: IdiomsFragmentListBinding

    override fun provideViewModel() = customViewModel
    override fun getViewResource() = R.layout.idioms_fragment_list

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = IdiomsFragmentListBinding.inflate(inflater, container, false)
        binding.viewModel = customViewModel
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idiomsAdapter = IdiomsAdapter()
        idiomsList.adapter = idiomsAdapter
        idiomsList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search, menu)

        (menu.findItem(R.id.action_search).actionView as SearchView).apply {
            queryHint = getString(R.string.search)
            setOnQueryTextListener(
                DebouncingQueryTextListener(this@IdiomsListFragment) {
                    if (it.isNullOrEmpty()) viewModel.resetSearch() else viewModel.search(it)
                }
            )
            clearFocus()
        }
    }

    override fun render(viewState: IdiomsListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        binding.viewState = viewState
    }
}
