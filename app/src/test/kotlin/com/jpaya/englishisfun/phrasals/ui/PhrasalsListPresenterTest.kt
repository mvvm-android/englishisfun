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

import com.jpaya.englishisfun.phrasals.domain.Phrasal
import com.jpaya.englishisfun.phrasals.domain.PhrasalsInteractor
import com.jpaya.englishisfun.phrasals.ui.model.PhrasalItem
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PhrasalsListPresenterTest {

    companion object {
        private val MOCK_PHRASALS_LIST = listOf(
            Phrasal(
                id = 1,
                verb = "Verb 1",
                definitions = "Definition 1"
            ),
            Phrasal(
                id = 2,
                verb = "Verb 2",
                definitions = "Definition 2"
            )
        )
    }

    private lateinit var interactor: PhrasalsInteractor
    private lateinit var presenter: PhrasalsListPresenter

    @Before
    fun setUp() {
        interactor = mock()
        presenter = PhrasalsListPresenter(interactor)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getPhrasalsItems works properly`() = runBlocking {
        whenever(interactor.getPhrasalsItems()).doReturn(MOCK_PHRASALS_LIST)

        val expectedResult = listOf(
            PhrasalItem(
                id = 1,
                verb = "Verb 1",
                definitions = "Definition 1"
            ),
            PhrasalItem(
                id = 2,
                verb = "Verb 2",
                definitions = "Definition 2"
            )
        )

        assertEquals(expectedResult, presenter.getPhrasalsItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check searchPhrasals works properly`() = runBlocking {
        val filter = "Verb"
        whenever(interactor.searchPhrasals(filter)).doReturn(MOCK_PHRASALS_LIST)

        val expectedResult = listOf(
            PhrasalItem(
                id = 1,
                verb = "Verb 1",
                definitions = "Definition 1"
            ),
            PhrasalItem(
                id = 2,
                verb = "Verb 2",
                definitions = "Definition 2"
            )
        )

        assertEquals(expectedResult, presenter.searchPhrasals(filter))
    }
}
