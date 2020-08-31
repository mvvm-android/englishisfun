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

package com.jpaya.englishisfun.stative.ui

import co.zsmb.rainbowcake.withIOContext
import com.jpaya.englishisfun.stative.domain.StativeInteractor
import com.jpaya.englishisfun.stative.mapper.toPresentation
import javax.inject.Inject

class StativePresenter @Inject constructor(
    private val interactor: StativeInteractor
) {

    suspend fun getStativeItems(): List<StativeItem> = withIOContext {
        interactor.getStativeItems().map { it.toPresentation() }
    }

    suspend fun searchStative(filter: String): List<StativeItem> = withIOContext {
        interactor.searchStative(filter).map { it.toPresentation() }
    }

    data class StativeItem(
        val id: Long,
        val base: String,
        val simple: String,
        val participle: String,
        val definitions: String
    )
}
