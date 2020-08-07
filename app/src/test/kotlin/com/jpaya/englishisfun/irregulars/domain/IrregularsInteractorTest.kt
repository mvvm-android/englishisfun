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

package com.jpaya.englishisfun.irregulars.domain

import com.jpaya.englishisfun.irregulars.data.db.DatabaseDataSource
import com.jpaya.englishisfun.irregulars.data.network.NetworkDataSource
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class IrregularsInteractorTest {

    companion object {
        private val MOCK_IRREGULARS_ITEMS = listOf(
            Irregulars(
                id = 1,
                base = "Base 1",
                simple = "Simple 1",
                participle = "Participle 1",
                definitions = "Definitions 1"
            ),
            Irregulars(
                id = 2,
                base = "Base 2",
                simple = "Simple 2",
                participle = "Participle 2",
                definitions = "Definitions 2"
            )
        )
    }

    private lateinit var network: NetworkDataSource
    private lateinit var database: DatabaseDataSource
    private lateinit var interactor: IrregularsInteractor

    @Before
    fun setUp() {
        network = mock()
        database = mock()
        interactor = IrregularsInteractor(network, database)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getIrregularsItems works properly`() = runBlockingTest {
        whenever(network.getIrregularsItems()).doReturn(MOCK_IRREGULARS_ITEMS)

        assertEquals(2, interactor.getIrregularsItems().size)
        assertEquals(MOCK_IRREGULARS_ITEMS, interactor.getIrregularsItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check searchIrregulars works properly`() = runBlockingTest {
        val filter = "filter"
        whenever(database.search(filter)).doReturn(MOCK_IRREGULARS_ITEMS)

        assertEquals(2, database.search(filter).size)
        assertEquals(MOCK_IRREGULARS_ITEMS, interactor.searchIrregulars(filter))
    }
}
