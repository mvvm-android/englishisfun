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

package com.jpaya.englishisfun.suggestions.ui

import androidx.fragment.app.viewModels
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import com.jpaya.englishisfun.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuggestionsFragment : RainbowCakeFragment<SuggestionsViewState, SuggestionsViewModel>() {

    private val customViewModel: SuggestionsViewModel by viewModels()

    override fun provideViewModel() = customViewModel
    override fun getViewResource() = R.layout.suggestions_fragment

    override fun render(viewState: SuggestionsViewState) {
        // TODO
    }
}
