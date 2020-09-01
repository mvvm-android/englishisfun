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

package com.jpaya.englishisfun.conditionals.domain

import com.jpaya.englishisfun.conditionals.data.db.DatabaseDataSource
import com.jpaya.englishisfun.conditionals.data.network.NetworkDataSource
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ConditionalsInteractorTest {

    companion object {
        private val MOCK_CONDITIONALS_ITEMS = listOf(
            Conditional(
                id = 1,
                name = "Name 1",
                condition = "Condition 1",
                result = "Result 1",
                uses = mutableListOf("Use 1"),
                examples = mutableListOf("Example 1")
            ),
            Conditional(
                id = 2,
                name = "Name 2",
                condition = "Condition 2",
                result = "Result 2",
                uses = mutableListOf("Use 1"),
                examples = mutableListOf("Example 1")
            )
        )
    }

    private lateinit var network: NetworkDataSource
    private lateinit var database: DatabaseDataSource
    private lateinit var interactor: ConditionalsInteractor

    @Before
    fun setUp() {
        network = mock()
        database = mock()
        interactor = ConditionalsInteractor(network, database)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getConditionalsItems works properly`() = runBlockingTest {
        whenever(network.getConditionalsItems()).doReturn(MOCK_CONDITIONALS_ITEMS)

        assertEquals(2, interactor.getConditionalsItems().size)
        assertEquals(MOCK_CONDITIONALS_ITEMS, interactor.getConditionalsItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check searchConditionals works properly`() = runBlockingTest {
        val filter = "filter"
        whenever(database.search(filter)).doReturn(MOCK_CONDITIONALS_ITEMS)

        assertEquals(2, database.search(filter).size)
        assertEquals(MOCK_CONDITIONALS_ITEMS, interactor.searchConditionals(filter))
    }
}
