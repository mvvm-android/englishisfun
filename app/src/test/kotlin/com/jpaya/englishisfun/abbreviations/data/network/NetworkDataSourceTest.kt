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

package com.jpaya.englishisfun.abbreviations.data.network

import com.jpaya.englishisfun.abbreviations.data.network.model.AbbreviationNetworkItem
import com.jpaya.englishisfun.abbreviations.data.network.model.AbbreviationsResponse
import com.jpaya.englishisfun.abbreviations.domain.Abbreviation
import com.jpaya.englishisfun.data.firebase.FireStoreClient
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NetworkDataSourceTest {

    companion object {
        private val MOCK_ABBREVIATIONS_DOCUMENT = AbbreviationsResponse().apply {
            abbreviations = listOf(
                AbbreviationNetworkItem().apply {
                    id = 1
                    abbr = "Abbreviation 1"
                    desc = "Description 1"
                },
                AbbreviationNetworkItem().apply {
                    id = 2
                    abbr = "Abbreviation 2"
                    desc = "Description 2"
                }
            )
        }
    }

    private lateinit var fireStoreClient: FireStoreClient
    private lateinit var dataSource: NetworkDataSource

    @Before
    fun setUp() {
        fireStoreClient = mock()
        dataSource = NetworkDataSource(fireStoreClient)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getAbbreviationItems works properly`() = runBlockingTest {
        whenever(fireStoreClient.abbreviations()).doReturn(MOCK_ABBREVIATIONS_DOCUMENT)

        val expectedResult = listOf(
            Abbreviation(
                id = 1,
                abbr = "Abbreviation 1",
                desc = "Description 1"
            ),
            Abbreviation(
                id = 2,
                abbr = "Abbreviation 2",
                desc = "Description 2"
            )
        )

        assertEquals(expectedResult, dataSource.getAbbreviations())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getAbbreviationItems works properly when null list`() = runBlockingTest {
        whenever(fireStoreClient.abbreviations()).doReturn(AbbreviationsResponse())

        val expectedResult = emptyList<Abbreviation>()

        assertEquals(expectedResult, dataSource.getAbbreviations())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getAbbreviationItems works properly when null`() = runBlockingTest {
        whenever(fireStoreClient.abbreviations()).doReturn(null)

        val expectedResult = emptyList<Abbreviation>()

        assertEquals(expectedResult, dataSource.getAbbreviations())
    }
}
