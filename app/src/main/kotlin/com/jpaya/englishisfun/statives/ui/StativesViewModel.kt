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

import androidx.hilt.lifecycle.ViewModelInject
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.jpaya.englishisfun.statives.ui.StativesViewState.ListReady
import com.jpaya.englishisfun.statives.ui.StativesViewState.Loading
import com.jpaya.englishisfun.statives.ui.StativesViewState.NetworkError
import java.io.IOException

class StativesViewModel @ViewModelInject constructor(
    private val presenter: StativesPresenter
) : RainbowCakeViewModel<StativesViewState>(Loading) {

    fun init() = execute { loadStative() }

    fun reload() = execute { loadStative() }

    private suspend fun loadStative() {
        viewState = Loading
        viewState = try {
            ListReady(presenter.getStativeItems())
        } catch (e: IOException) {
            NetworkError
        }
    }
}
