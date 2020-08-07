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

package com.jpaya.englishisfun.abbreviations.domain

import com.jpaya.englishisfun.abbreviations.data.db.DatabaseDataSource
import com.jpaya.englishisfun.abbreviations.data.network.NetworkDataSource
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AbbreviationsInteractorTest {

    companion object {
        private val MOCK_ABBREVIATIONS_ITEMS = listOf(
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

    private lateinit var network: NetworkDataSource
    private lateinit var database: DatabaseDataSource
    private lateinit var interactor: AbbreviationsInteractor

    @Before
    fun setUp() {
        network = mock()
        database = mock()
        interactor = AbbreviationsInteractor(network, database)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getIrregularsItems works properly`() = runBlockingTest {
        whenever(network.getAbbreviationItems()).doReturn(MOCK_ABBREVIATIONS_ITEMS)

        assertEquals(2, interactor.getAbbreviationItems().size)
        assertEquals(MOCK_ABBREVIATIONS_ITEMS, interactor.getAbbreviationItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check searchIrregulars works properly`() = runBlockingTest {
        val filter = "filter"
        whenever(database.search(filter)).doReturn(MOCK_ABBREVIATIONS_ITEMS)

        assertEquals(2, database.search(filter).size)
        assertEquals(MOCK_ABBREVIATIONS_ITEMS, interactor.searchAbbreviations(filter))
    }
}
