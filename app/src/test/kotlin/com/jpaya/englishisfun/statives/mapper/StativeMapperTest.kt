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

package com.jpaya.englishisfun.statives.mapper

import com.jpaya.englishisfun.statives.data.db.StativeRoomItem
import com.jpaya.englishisfun.statives.data.network.model.StativeNetworkItem
import com.jpaya.englishisfun.statives.domain.Stative
import com.jpaya.englishisfun.statives.ui.model.StativeItem
import org.junit.Assert.assertEquals
import org.junit.Test

class StativeMapperTest {

    @Test
    fun `Check domain to room works properly`() {
        val domain = Stative(
            id = 1,
            category = "Category 1",
            verbs = mutableListOf("Verb 1")
        )

        val expectedResult = StativeRoomItem(
            id = 1,
            category = "Category 1",
            verbs = mutableListOf("Verb 1")
        )

        assertEquals(expectedResult, domain.toRoomItem())
    }

    @Test
    fun `Check room to domain works properly`() {
        val room = StativeRoomItem(
            id = 1,
            category = "Category 1",
            verbs = mutableListOf("Verb 1")
        )

        val expectedResult = Stative(
            id = 1,
            category = "Category 1",
            verbs = mutableListOf("Verb 1")
        )

        assertEquals(expectedResult, room.toDomain())
    }

    @Test
    fun `Check network to domain works properly`() {
        val network = StativeNetworkItem().apply {
            id = 1
            category = "Category 1"
            verbs = mutableListOf("Verb 1")
        }

        val expectedResult = Stative(
            id = 1,
            category = "Category 1",
            verbs = mutableListOf("Verb 1")
        )

        assertEquals(expectedResult, network.toDomain())
    }

    @Test
    fun `Check domain to presentation works properly`() {
        val domain = Stative(
            id = 1,
            category = "Category 1",
            verbs = mutableListOf("Verb 1")
        )

        val expectedResult = StativeItem(
            id = 1,
            category = "Category 1",
            verbs = mutableListOf("Verb 1")
        )

        assertEquals(expectedResult, domain.toPresentation())
    }
}
