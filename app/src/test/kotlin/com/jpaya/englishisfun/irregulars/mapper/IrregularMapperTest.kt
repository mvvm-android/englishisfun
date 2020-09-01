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

package com.jpaya.englishisfun.irregulars.mapper

import com.jpaya.englishisfun.irregulars.data.db.IrregularRoomItem
import com.jpaya.englishisfun.irregulars.data.network.model.IrregularNetworkItem
import com.jpaya.englishisfun.irregulars.domain.Irregular
import com.jpaya.englishisfun.irregulars.ui.model.IrregularItem
import org.junit.Assert.assertEquals
import org.junit.Test

class IrregularMapperTest {

    @Test
    fun `Check domain to room works properly`() {
        val domain = Irregular(
            id = 1,
            base = "Base",
            simple = "Simple",
            participle = "Participle",
            definitions = "Definitions"
        )

        val expectedResult = IrregularRoomItem(
            id = 1,
            base = "Base",
            simple = "Simple",
            participle = "Participle",
            definitions = "Definitions"
        )

        assertEquals(expectedResult, domain.toRoomItem())
    }

    @Test
    fun `Check room to domain works properly`() {
        val room = IrregularRoomItem(
            id = 1,
            base = "Base",
            simple = "Simple",
            participle = "Participle",
            definitions = "Definitions"
        )

        val expectedResult = Irregular(
            id = 1,
            base = "Base",
            simple = "Simple",
            participle = "Participle",
            definitions = "Definitions"
        )

        assertEquals(expectedResult, room.toDomain())
    }

    @Test
    fun `Check network to domain works properly`() {
        val network = IrregularNetworkItem().apply {
            id = 1
            base = "Base"
            simple = "Simple"
            participle = "Participle"
            definitions = "Definitions"
        }

        val expectedResult = Irregular(
            id = 1,
            base = "Base",
            simple = "Simple",
            participle = "Participle",
            definitions = "Definitions"
        )

        assertEquals(expectedResult, network.toDomain())
    }

    @Test
    fun `Check domain to presentation works properly`() {
        val domain = Irregular(
            id = 1,
            base = "Base",
            simple = "Simple",
            participle = "Participle",
            definitions = "Definitions"
        )

        val expectedResult = IrregularItem(
            id = 1,
            base = "Base",
            simple = "Simple",
            participle = "Participle",
            definitions = "Definitions"
        )

        assertEquals(expectedResult, domain.toPresentation())
    }
}
