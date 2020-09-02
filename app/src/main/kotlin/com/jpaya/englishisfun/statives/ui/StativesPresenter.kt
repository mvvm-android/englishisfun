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

import co.zsmb.rainbowcake.withIOContext
import com.jpaya.englishisfun.statives.domain.StativesInteractor
import com.jpaya.englishisfun.statives.mapper.toPresentation
import com.jpaya.englishisfun.statives.ui.model.StativeItem
import javax.inject.Inject

class StativesPresenter @Inject constructor(
    private val interactor: StativesInteractor
) {

    suspend fun getStativeItems(): List<StativeItem> = withIOContext {
        interactor.getStativeItems().map { it.toPresentation() }
    }

    suspend fun searchStative(filter: String): List<StativeItem> = withIOContext {
        interactor.searchStative(filter).map { it.toPresentation() }
    }
}
