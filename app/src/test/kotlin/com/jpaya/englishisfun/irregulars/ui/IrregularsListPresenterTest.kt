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

import com.jpaya.englishisfun.irregulars.domain.Irregular
import com.jpaya.englishisfun.irregulars.domain.IrregularsInteractor
import com.jpaya.englishisfun.irregulars.ui.model.IrregularItem
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class IrregularsListPresenterTest {

    companion object {
        private val MOCK_IRREGULARS_LIST = listOf(
            Irregular(
                id = 1,
                base = "Base 1",
                simple = "Simple 1",
                participle = "Participle 1",
                definitions = "Definitions 1"
            ),
            Irregular(
                id = 2,
                base = "Base 2",
                simple = "Simple 2",
                participle = "Participle 2",
                definitions = "Definitions 2"
            )
        )
    }

    private lateinit var interactor: IrregularsInteractor
    private lateinit var presenter: IrregularsListPresenter

    @Before
    fun setUp() {
        interactor = mock()
        presenter = IrregularsListPresenter(interactor)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getIrregularsItems works properly`() = runBlocking {
        whenever(interactor.getIrregularsItems()).doReturn(MOCK_IRREGULARS_LIST)

        val expectedResult = listOf(
            IrregularItem(
                id = 1,
                base = "Base 1",
                simple = "Simple 1",
                participle = "Participle 1",
                definitions = "Definitions 1"
            ),
            IrregularItem(
                id = 2,
                base = "Base 2",
                simple = "Simple 2",
                participle = "Participle 2",
                definitions = "Definitions 2"
            )
        )

        assertEquals(expectedResult, presenter.getIrregularsItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check searchIrregulars works properly`() = runBlocking {
        val filter = "Base"
        whenever(interactor.searchIrregulars(filter)).doReturn(MOCK_IRREGULARS_LIST)

        val expectedResult = listOf(
            IrregularItem(
                id = 1,
                base = "Base 1",
                simple = "Simple 1",
                participle = "Participle 1",
                definitions = "Definitions 1"
            ),
            IrregularItem(
                id = 2,
                base = "Base 2",
                simple = "Simple 2",
                participle = "Participle 2",
                definitions = "Definitions 2"
            )
        )

        assertEquals(expectedResult, presenter.searchIrregulars(filter))
    }
}
