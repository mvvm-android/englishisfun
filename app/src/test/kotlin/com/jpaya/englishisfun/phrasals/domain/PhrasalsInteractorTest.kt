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

package com.jpaya.englishisfun.phrasals.domain

import com.jpaya.englishisfun.phrasals.data.db.DatabaseDataSource
import com.jpaya.englishisfun.phrasals.data.network.NetworkDataSource
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PhrasalsInteractorTest {

    companion object {
        private val MOCK_PHRASALS_ITEMS = listOf(
            Phrasal(
                id = 1,
                verb = "Verb 1",
                definitions = "Definitions 1"
            ),
            Phrasal(
                id = 2,
                verb = "Verb 2",
                definitions = "Definitions 2"
            )
        )
    }

    private lateinit var network: NetworkDataSource
    private lateinit var database: DatabaseDataSource
    private lateinit var interactor: PhrasalsInteractor

    @Before
    fun setUp() {
        network = mock()
        database = mock()
        interactor = PhrasalsInteractor(network, database)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getPhrasalsItems works properly`() = runBlockingTest {
        whenever(network.getPhrasalsItems()).doReturn(MOCK_PHRASALS_ITEMS)

        assertEquals(2, interactor.getPhrasalsItems().size)
        assertEquals(MOCK_PHRASALS_ITEMS, interactor.getPhrasalsItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check searchPhrasals works properly`() = runBlockingTest {
        val filter = "filter"
        whenever(database.search(filter)).doReturn(MOCK_PHRASALS_ITEMS)

        assertEquals(2, database.search(filter).size)
        assertEquals(MOCK_PHRASALS_ITEMS, interactor.searchPhrasals(filter))
    }
}
