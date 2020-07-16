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

package com.jpaya.englishisfun.irregulars.ui

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.extensions.exhaustive
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.button.MaterialButton
import com.jpaya.englishisfun.R
import com.jpaya.englishisfun.extensions.hide
import com.jpaya.englishisfun.extensions.show
import com.jpaya.englishisfun.irregulars.ui.adapter.IrregularsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IrregularsListFragment :
    RainbowCakeFragment<ListViewState, IrregularsListViewModel>(), IrregularsAdapter.Listener {

    private val customViewModel: IrregularsListViewModel by viewModels()

    override fun provideViewModel() = customViewModel
    override fun getViewResource() = R.layout.irregulars_fragment_list

    private lateinit var irregularsAdapter: IrregularsAdapter

    // TODO REPLACE FOR KOTLIN AUTOIMPORT
    private lateinit var listFragmentRoot: ConstraintLayout
    private lateinit var toolbar: Toolbar
    private lateinit var shimmerLayout: ShimmerFrameLayout
    private lateinit var irregularsList: RecyclerView
    private lateinit var errorGroup: Group
    private lateinit var errorText: TextView
    private lateinit var retryButton: MaterialButton
    private lateinit var viewSavedButton: MaterialButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadUiRefs(view)

        irregularsAdapter = IrregularsAdapter()
        irregularsAdapter.listener = this
        irregularsList.adapter = irregularsAdapter
        irregularsList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        retryButton.setOnClickListener {
            viewModel.reload()
        }
        viewSavedButton.setOnClickListener {
//            navigator?.add(SavedFragment())
        }

        toolbar.inflateMenu(R.menu.menu_list)
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_view_saved -> {
//                    navigator?.add(SavedFragment())
                }
            }
            true
        }
    }

    private fun loadUiRefs(view: View) {
        listFragmentRoot = view.findViewById(R.id.listFragmentRoot)
        toolbar = view.findViewById(R.id.toolbar)
        shimmerLayout = view.findViewById(R.id.shimmerLayout)
        irregularsList = view.findViewById(R.id.irregularsList)
        errorGroup = view.findViewById(R.id.errorGroup)
        errorText = view.findViewById(R.id.errorText)
        retryButton = view.findViewById(R.id.retryButton)
        viewSavedButton = view.findViewById(R.id.viewSavedButton)
    }

    override fun render(viewState: ListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        when (viewState) {
            Loading -> {
                shimmerLayout.show()
                irregularsList.isVisible = false
                errorGroup.isVisible = false
            }
            is ListReady -> {
                irregularsAdapter.submitList(viewState.irregulars)
                shimmerLayout.hide()
                irregularsList.isVisible = true
                errorGroup.isVisible = false
            }
            NetworkError -> {
                irregularsAdapter.submitList(null)
                shimmerLayout.hide()
                irregularsList.isVisible = false
                errorGroup.isVisible = true
            }
        }.exhaustive
    }

    override fun onItemSelected(id: Long) {
//        navigator?.add(DetailFragment.newInstance(id))
    }
}
