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

import androidx.hilt.lifecycle.ViewModelInject
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.io.IOException

class IdiomsListViewModel @ViewModelInject constructor(
    private val presenter: IdiomsListPresenter
) : RainbowCakeViewModel<ListViewState>(Loading) {

    init {
        execute { loadIdioms() }
    }

    fun reload() {
        execute { loadIdioms() }
    }

    fun search(filter: String) {
        execute { searchIdioms(filter) }
    }

    fun resetSearch() {
        execute { loadIdioms() }
    }

    private suspend fun loadIdioms() {
        viewState = Loading
        viewState = try {
            ListReady(presenter.getIdiomsItems())
        } catch (e: IOException) {
            NetworkError
        }
    }

    private suspend fun searchIdioms(filter: String) {
        viewState = Loading
        viewState = try {
            ListReady(presenter.searchIdioms(filter))
        } catch (e: IOException) {
            NetworkError
        }
    }
}
