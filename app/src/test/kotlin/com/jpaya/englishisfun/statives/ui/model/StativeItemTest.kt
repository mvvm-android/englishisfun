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

package com.jpaya.englishisfun.statives.ui.model

import org.junit.Assert.*
import org.junit.Test

class StativeItemTest {

    @Test
    fun `Init should initialise properly`() {
        val id: Long = 1
        val category = "Category"
        val verbs = mutableListOf("Verb 1")

        val item = StativeItem(id, category, verbs)

        assertEquals(id, item.id)
        assertEquals(category, item.category)
        assertEquals(verbs, item.verbs)
    }

    @Test
    fun `Check that comparator works properly`() {
        // Different data
        val item1 = StativeItem(1, "Category 1", mutableListOf("Verb 1"))
        val item2 = StativeItem(2, "Category 2", mutableListOf("Verb 2"))
        assertFalse(item1.isSameItemAs(item2))
        assertFalse(item1.hasSameContentsAs(item2))

        // Same Id
        val item3 = StativeItem(1, "Category 3", mutableListOf("Verb 3"))
        assertTrue(item1.isSameItemAs(item3))
        assertFalse(item1.hasSameContentsAs(item3))

        // Same data
        val item4 = StativeItem(1, "Category 1", mutableListOf("Verb 1"))
        assertTrue(item1.isSameItemAs(item4))
        assertTrue(item1.hasSameContentsAs(item4))
    }
}
