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

package com.jpaya.englishisfun.statives.domain

import com.jpaya.englishisfun.statives.data.db.DatabaseDataSource
import com.jpaya.englishisfun.statives.data.network.NetworkDataSource
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class StativesInteractorTest {

    companion object {
        private val MOCK_STATIVES_ITEMS = listOf(
            Stative(
                id = 1,
                category = "Category 1",
                verbs = mutableListOf("Verb 1")
            ),
            Stative(
                id = 2,
                category = "Category 2",
                verbs = mutableListOf("Verb 2")
            )
        )
    }

    private lateinit var network: NetworkDataSource
    private lateinit var database: DatabaseDataSource
    private lateinit var interactor: StativesInteractor

    @Before
    fun setUp() {
        network = mock()
        database = mock()
        interactor = StativesInteractor(network, database)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getIrregularsItems works properly`() = runBlockingTest {
        whenever(network.getStativeItems()).doReturn(MOCK_STATIVES_ITEMS)

        assertEquals(2, interactor.getStativeItems().size)
        assertEquals(MOCK_STATIVES_ITEMS, interactor.getStativeItems())
    }
}
