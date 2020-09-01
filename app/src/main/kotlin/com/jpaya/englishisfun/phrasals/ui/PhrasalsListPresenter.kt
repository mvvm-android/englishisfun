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

import co.zsmb.rainbowcake.withIOContext
import com.jpaya.englishisfun.phrasals.domain.PhrasalsInteractor
import com.jpaya.englishisfun.phrasals.mapper.toPresentation
import com.jpaya.englishisfun.phrasals.ui.model.PhrasalItem
import javax.inject.Inject

class PhrasalsListPresenter @Inject constructor(
    private val interactor: PhrasalsInteractor
) {

    suspend fun getPhrasalsItems(): List<PhrasalItem> = withIOContext {
        interactor.getPhrasalsItems().map { it.toPresentation() }
    }

    suspend fun searchPhrasals(filter: String): List<PhrasalItem> = withIOContext {
        interactor.searchPhrasals(filter).map { it.toPresentation() }
    }
}
