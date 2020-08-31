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

import co.zsmb.rainbowcake.withIOContext
import com.jpaya.englishisfun.conditionals.mapper.toPresentation
import com.jpaya.englishisfun.conditionals.domain.ConditionalsInteractor
import com.jpaya.englishisfun.conditionals.ui.model.ConditionalItem
import javax.inject.Inject

class ConditionalsListPresenter @Inject constructor(
    private val interactor: ConditionalsInteractor
) {

    suspend fun getConditionalsItems(): List<ConditionalItem> = withIOContext {
        interactor.getConditionalsItems().map { it.toPresentation() }
    }

    suspend fun searchConditionals(filter: String): List<ConditionalItem> = withIOContext {
        interactor.searchConditionals(filter).map { it.toPresentation() }
    }
}
