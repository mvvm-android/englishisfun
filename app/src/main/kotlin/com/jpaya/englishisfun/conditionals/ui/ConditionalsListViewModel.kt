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

package com.jpaya.englishisfun.conditionals.ui

import androidx.hilt.lifecycle.ViewModelInject
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.jpaya.englishisfun.conditionals.ui.ConditionalsListViewState.ListReady
import com.jpaya.englishisfun.conditionals.ui.ConditionalsListViewState.Loading
import com.jpaya.englishisfun.conditionals.ui.ConditionalsListViewState.NetworkError
import java.io.IOException

class ConditionalsListViewModel @ViewModelInject constructor(
    private val presenter: ConditionalsListPresenter
) : RainbowCakeViewModel<ConditionalsListViewState>(Loading) {

    init {
        execute { loadConditionals() }
    }

    fun reload() = execute { loadConditionals() }

    fun search(filter: String) {
        execute { searchConditionals(filter) }
    }

    fun resetSearch() {
        execute { loadConditionals() }
    }

    private suspend fun loadConditionals() {
        viewState = Loading
        viewState = try {
            ListReady(presenter.getConditionalsItems())
        } catch (e: IOException) {
            NetworkError
        }
    }

    private suspend fun searchConditionals(filter: String) {
        viewState = Loading
        viewState = try {
            ListReady(presenter.searchConditionals(filter))
        } catch (e: IOException) {
            NetworkError
        }
    }
}
