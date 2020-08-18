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
import com.jpaya.englishisfun.conditionals.domain.ConditionalsInteractor
import javax.inject.Inject

class ConditionalsListPresenter @Inject constructor(
    private val interactor: ConditionalsInteractor
) {

    suspend fun getConditionalsItems(): List<ConditionalsItem> = withIOContext {
        interactor.getConditionalsItems().map {
            ConditionalsItem(
                id = it.id,
                base = it.base,
                simple = it.simple,
                participle = it.participle,
                definitions = it.definitions
            )
        }
    }

    suspend fun searchConditionals(filter: String): List<ConditionalsItem> = withIOContext {
        interactor.searchConditionals(filter).map {
            ConditionalsItem(
                id = it.id,
                base = it.base,
                simple = it.simple,
                participle = it.participle,
                definitions = it.definitions
            )
        }
    }

    data class ConditionalsItem(
        val id: Long,
        val base: String,
        val simple: String,
        val participle: String,
        val definitions: String
    )
}
