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

import com.jpaya.englishisfun.abbreviations.domain.Abbreviations
import com.jpaya.englishisfun.abbreviations.domain.AbbreviationsInteractor
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AbbreviationsListPresenterTest {

    companion object {
        private val MOCK_ABBREVIATIONS_LIST = listOf(
            Abbreviations(
                id = 1,
                abbr = "Abbreviation 1",
                desc = "Description 1"
            ),
            Abbreviations(
                id = 2,
                abbr = "Abbreviation 2",
                desc = "Description 2"
            )
        )
    }

    private lateinit var interactor: AbbreviationsInteractor
    private lateinit var presenter: AbbreviationsListPresenter

    @Before
    fun setUp() {
        interactor = mock()
        presenter = AbbreviationsListPresenter(interactor)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getIrregularsItems works properly`() = runBlocking {
        whenever(interactor.getAbbreviationItems()).doReturn(MOCK_ABBREVIATIONS_LIST)

        val expectedResult = listOf(
            AbbreviationsListPresenter.AbbreviationsItem(
                id = 1,
                abbr = "Abbreviation 1",
                desc = "Description 1"
            ),
            AbbreviationsListPresenter.AbbreviationsItem(
                id = 2,
                abbr = "Abbreviation 2",
                desc = "Description 2"
            )
        )

        assertEquals(expectedResult, presenter.getAbbreviationItems())
    }
}
