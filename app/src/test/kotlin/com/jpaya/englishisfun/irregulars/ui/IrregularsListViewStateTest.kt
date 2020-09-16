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

package com.jpaya.englishisfun.irregulars.ui

import com.jpaya.englishisfun.irregulars.ui.IrregularsListViewState.Loading
import com.jpaya.englishisfun.irregulars.ui.IrregularsListViewState.ListReady
import com.jpaya.englishisfun.irregulars.ui.IrregularsListViewState.NetworkError
import com.jpaya.englishisfun.irregulars.ui.model.IrregularItem
import org.junit.Assert.*
import org.junit.Test

class IrregularsListViewStateTest {

    @Test
    fun `Check Loading state works properly`() {
        val loading = Loading
        assertTrue(loading.showLoading())
        assertFalse(loading.showError())
        assertFalse(loading.showList())
        assertTrue(loading.list().isEmpty())
    }

    @Test
    fun `Check ListReady state works properly`() {
        val irregulars = listOf(
            IrregularItem(
                id = 1,
                base = "Base",
                simple = "Simple",
                participle = "Participle",
                definitions = "Definitions",
            )
        )
        val loading = ListReady(irregulars)
        assertFalse(loading.showLoading())
        assertFalse(loading.showError())
        assertTrue(loading.showList())
        assertEquals(irregulars, loading.list())
    }

    @Test
    fun `Check NetworkError state works properly`() {
        val loading = NetworkError
        assertFalse(loading.showLoading())
        assertTrue(loading.showError())
        assertFalse(loading.showList())
        assertTrue(loading.list().isEmpty())
    }
}