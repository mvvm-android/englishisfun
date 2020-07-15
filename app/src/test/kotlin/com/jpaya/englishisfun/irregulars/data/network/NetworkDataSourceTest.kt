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

package com.jpaya.englishisfun.irregulars.data.network

import com.jpaya.englishisfun.abbreviations.model.AbbreviationItem
import com.jpaya.englishisfun.abbreviations.model.AbbreviationsDocument
import com.jpaya.englishisfun.firestore.FireStoreClient
import com.jpaya.englishisfun.irregulars.domain.Irregulars
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class NetworkDataSourceTest {

    companion object {
        private val MOCK_IRREGULARS_DOCUMENT = AbbreviationsDocument().apply {
            abbreviations = listOf(
                AbbreviationItem().apply {
                    id = 1
                    abbr = "Abbr 1"
                    desc = "Desc 1"
                },
                AbbreviationItem().apply {
                    id = 2
                    abbr = "Abbr 2"
                    desc = "Desc 2"
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
    fun `Check getIrregularsItems works properly`() = runBlockingTest {
        whenever(fireStoreClient.abbreviations()).doReturn(MOCK_IRREGULARS_DOCUMENT)

        val expectedResult = listOf(
            Irregulars(
                id = 1,
                base = "Base",
                simple = "Simple",
                participle = "Participle",
                definitions = "Definitions"
            ),
            Irregulars(
                id = 2,
                base = "Base",
                simple = "Simple",
                participle = "Participle",
                definitions = "Definitions"
            )
        )

        val result = dataSource.getIrregularsItems()
        assertEquals(expectedResult, result)
    }
}
