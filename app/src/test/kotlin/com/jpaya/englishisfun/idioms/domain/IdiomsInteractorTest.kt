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

package com.jpaya.englishisfun.idioms.domain

import com.jpaya.englishisfun.idioms.data.db.DatabaseDataSource
import com.jpaya.englishisfun.idioms.data.network.NetworkDataSource
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class IdiomsInteractorTest {

    companion object {
        private val MOCK_IDIOMS_ITEMS = listOf(
            Idiom(
                id = 1,
                idiom = "Idiom 1",
                description = "Description 1"
            ),
            Idiom(
                id = 2,
                idiom = "Idiom 2",
                description = "Description 2"
            )
        )
    }

    private lateinit var network: NetworkDataSource
    private lateinit var database: DatabaseDataSource
    private lateinit var interactor: IdiomsInteractor

    @Before
    fun setUp() {
        network = mock()
        database = mock()
        interactor = IdiomsInteractor(network, database)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getIdiomsItems works properly`() = runBlockingTest {
        whenever(network.getIdiomsItems()).doReturn(MOCK_IDIOMS_ITEMS)

        assertEquals(2, interactor.getIdiomsItems().size)
        assertEquals(MOCK_IDIOMS_ITEMS, interactor.getIdiomsItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check searchIdioms works properly`() = runBlockingTest {
        val filter = "Idiom"
        whenever(database.search(filter)).doReturn(MOCK_IDIOMS_ITEMS)

        assertEquals(2, database.search(filter).size)
        assertEquals(MOCK_IDIOMS_ITEMS, interactor.searchIdioms(filter))
    }
}
