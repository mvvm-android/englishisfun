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

package com.jpaya.englishisfun.phrasals.ui

import androidx.hilt.lifecycle.ViewModelInject
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.jpaya.englishisfun.phrasals.ui.PhrasalsListViewState.ListReady
import com.jpaya.englishisfun.phrasals.ui.PhrasalsListViewState.Loading
import com.jpaya.englishisfun.phrasals.ui.PhrasalsListViewState.NetworkError
import java.io.IOException

class PhrasalsListViewModel @ViewModelInject constructor(
    private val presenter: PhrasalsListPresenter
) : RainbowCakeViewModel<PhrasalsListViewState>(Loading) {

    init {
        execute { loadPhrasals() }
    }

    fun reload() = execute { loadPhrasals() }

    fun search(filter: String) = execute { searchPhrasals(filter) }

    fun resetSearch() = execute { loadPhrasals() }

    private suspend fun loadPhrasals() {
        viewState = Loading
        viewState = try {
            ListReady(presenter.getPhrasalsItems())
        } catch (e: IOException) {
            NetworkError
        }
    }

    private suspend fun searchPhrasals(filter: String) {
        viewState = Loading
        viewState = try {
            ListReady(presenter.searchPhrasals(filter))
        } catch (e: IOException) {
            NetworkError
        }
    }
}
