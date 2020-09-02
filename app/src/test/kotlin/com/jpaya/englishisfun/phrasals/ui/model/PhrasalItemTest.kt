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

package com.jpaya.englishisfun.phrasals.ui.model

import org.junit.Assert.*
import org.junit.Test

class PhrasalItemTest {

    @Test
    fun `Init should initialise properly`() {
        val id: Long = 1
        val verb = "Verb"
        val definitions = "Definition"

        val item = PhrasalItem(id, verb, definitions)

        assertEquals(id, item.id)
        assertEquals(verb, item.verb)
        assertEquals(definitions, item.definitions)
    }

    @Test
    fun `Check that comparator works properly`() {
        // Different data
        val item1 = PhrasalItem(1, "Verb 1", "Definitions 1")
        val item2 = PhrasalItem(2, "Verb 2", "Definitions 2")
        assertFalse(item1.isSameItemAs(item2))
        assertFalse(item1.hasSameContentsAs(item2))

        // Same Id
        val item3 = PhrasalItem(1, "Verb 3", "Definitions 3")
        assertTrue(item1.isSameItemAs(item3))
        assertFalse(item1.hasSameContentsAs(item3))

        // Same data
        val item4 = PhrasalItem(1, "Verb 1", "Definitions 1")
        assertTrue(item1.isSameItemAs(item4))
        assertTrue(item1.hasSameContentsAs(item4))
    }
}
