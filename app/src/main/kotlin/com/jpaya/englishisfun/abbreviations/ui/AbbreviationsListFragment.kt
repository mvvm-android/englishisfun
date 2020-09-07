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

package com.jpaya.englishisfun.abbreviations.ui

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
import com.jpaya.englishisfun.abbreviations.ui.adapter.AbbreviationsAdapter
import com.jpaya.englishisfun.data.network.WooCommerceService
import com.jpaya.englishisfun.data.network.model.ProductNetworkItem
import com.jpaya.englishisfun.extensions.DebouncingQueryTextListener
import com.jpaya.englishisfun.extensions.hide
import com.jpaya.englishisfun.extensions.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.abbreviations_fragment_list.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@AndroidEntryPoint
class AbbreviationsListFragment :
    RainbowCakeFragment<AbbreviationsListViewState, AbbreviationsListViewModel>(), AbbreviationsAdapter.Listener {

    private val customViewModel: AbbreviationsListViewModel by viewModels()
    private lateinit var abbreviationsAdapter: AbbreviationsAdapter

    override fun provideViewModel() = customViewModel
    override fun getViewResource() = R.layout.abbreviations_fragment_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.137:8888/wp-json/wc/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(AuthIntercepter("ck_8f10a9e2cb2051e2b5c03abe4000c6a0c4904f2a", "cs_074eeb483d8602ac9d41503bba1f67bad3914367"))
                    .build()
            )
            .build()

        val service: WooCommerceService = retrofit.create(WooCommerceService::class.java)
        service.listProducts()
            .enqueue(object : Callback<List<ProductNetworkItem>> {
                override fun onResponse(
                    call: Call<List<ProductNetworkItem>>,
                    response: Response<List<ProductNetworkItem>>
                ) {
                    val aux = ""
                }

                override fun onFailure(call: Call<List<ProductNetworkItem>>, t: Throwable) {
                    val aux = ""
                }
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        abbreviationsAdapter = AbbreviationsAdapter(this)
        irregularsList.adapter = abbreviationsAdapter
        irregularsList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        retryButton.setOnClickListener {
            viewModel.reload()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search, menu)

        (menu.findItem(R.id.action_search).actionView as SearchView).apply {
            queryHint = getString(R.string.search)
            setIconifiedByDefault(false)
            setOnQueryTextListener(
                DebouncingQueryTextListener(this@AbbreviationsListFragment) {
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

    override fun render(viewState: AbbreviationsListViewState) {
        TransitionManager.beginDelayedTransition(listFragmentRoot)
        when (viewState) {
            Loading -> {
                shimmerLayout.show()
                irregularsList.isVisible = false
                errorGroup.isVisible = false
            }
            is ListReady -> {
                abbreviationsAdapter.submitList(viewState.abbreviations)
                shimmerLayout.hide()
                irregularsList.isVisible = true
                errorGroup.isVisible = false
            }
            NetworkError -> {
                abbreviationsAdapter.submitList(null)
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
