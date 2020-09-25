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

import com.jpaya.englishisfun.phrasals.ui.PhrasalsListViewState.Loading
import com.jpaya.englishisfun.phrasals.ui.PhrasalsListViewState.ListReady
import com.jpaya.englishisfun.phrasals.ui.PhrasalsListViewState.NetworkError
import com.jpaya.englishisfun.phrasals.ui.model.PhrasalItem
import org.junit.Assert.*
import org.junit.Test

class PhrasalsListViewStateTest {

    @Test
    fun `Check Loading state works properly`() {
        val loading = Loading
        assertTrue(loading.showLoading())
        assertFalse(loading.showError())
        assertFalse(loading.showList())
        assertFalse(loading.showEmpty())
        assertTrue(loading.list().isEmpty())
    }

    @Test
    fun `Check ListReady state works properly`() {
        // Non-empty list
        var list = listOf(
            PhrasalItem(
                id = 1,
                verb = "Verb",
                definitions = "Definitions"
            )
        )
        var state = ListReady(list)
        assertFalse(state.showLoading())
        assertFalse(state.showError())
        assertTrue(state.showList())
        assertFalse(state.showEmpty())
        assertEquals(list, state.list())

        // Empty list
        list = listOf()
        state = ListReady(list)
        assertFalse(state.showLoading())
        assertFalse(state.showError())
        assertFalse(state.showList())
        assertTrue(state.showEmpty())
        assertEquals(list, state.list())
    }

    @Test
    fun `Check NetworkError state works properly`() {
        val loading = NetworkError
        assertFalse(loading.showLoading())
        assertTrue(loading.showError())
        assertFalse(loading.showList())
        assertFalse(loading.showEmpty())
        assertTrue(loading.list().isEmpty())
    }
}
