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

package com.jpaya.englishisfun.idioms.data.network

import com.jpaya.englishisfun.firestore.FireStoreClient
import com.jpaya.englishisfun.idioms.data.network.model.IdiomsContent
import com.jpaya.englishisfun.idioms.data.network.model.IdiomsResponse
import com.jpaya.englishisfun.idioms.domain.Idioms
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
        private val MOCK_IDIOMS_DOCUMENT = IdiomsResponse().apply {
            idioms = listOf(
                IdiomsContent().apply {
                    id = 1
                    idiom = "Idiom 1"
                    description = "Description 1"
                },
                IdiomsContent().apply {
                    id = 2
                    idiom = "Idiom 2"
                    description = "Description 2"
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
    fun `Check getIdiomsItems works properly`() = runBlockingTest {
        whenever(fireStoreClient.idioms()).doReturn(MOCK_IDIOMS_DOCUMENT)

        val expectedResult = listOf(
            Idioms(
                id = 1,
                idiom = "Idiom 1",
                description = "Description 1"
            ),
            Idioms(
                id = 2,
                idiom = "Idiom 2",
                description = "Description 2"
            )
        )

        assertEquals(expectedResult, dataSource.getIdiomsItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getIdiomsItems works properly when null`() = runBlockingTest {
        whenever(fireStoreClient.idioms()).doReturn(null)

        val expectedResult = listOf<Idioms>()

        assertEquals(expectedResult, dataSource.getIdiomsItems())
    }
}
