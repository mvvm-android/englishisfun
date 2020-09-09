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

package com.jpaya.englishisfun.abbreviations.ui

import com.jpaya.englishisfun.abbreviations.ui.model.AbbreviationItem

sealed class AbbreviationsListViewState {
    abstract fun showLoading(): Boolean
    abstract fun showErrorGroup(): Boolean
    abstract fun showList(): Boolean
    abstract fun list(): List<AbbreviationItem>
}

object Loading : AbbreviationsListViewState() {
    override fun showLoading(): Boolean = true
    override fun showErrorGroup(): Boolean = false
    override fun showList(): Boolean = false
    override fun list(): List<AbbreviationItem> = listOf()
}

data class ListReady(val abbreviations: List<AbbreviationItem>) : AbbreviationsListViewState() {
    override fun showLoading(): Boolean = false
    override fun showErrorGroup(): Boolean = false
    override fun showList(): Boolean = true
    override fun list(): List<AbbreviationItem> = abbreviations
}

object NetworkError : AbbreviationsListViewState() {
    override fun showLoading(): Boolean = false
    override fun showErrorGroup(): Boolean = true
    override fun showList(): Boolean = false
    override fun list(): List<AbbreviationItem> = listOf()
}
