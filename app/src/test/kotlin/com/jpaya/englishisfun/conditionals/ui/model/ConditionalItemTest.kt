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

package com.jpaya.englishisfun.conditionals.ui.model

import org.junit.Assert.*
import org.junit.Test

class ConditionalItemTest {

    @Test
    fun `Init should initialise properly`() {
        val id: Long = 1
        val name = "Name"
        val condition = "Condition"
        val result = "Result"
        val uses = "Use 1"
        val examples = "Example 1"

        val item = ConditionalItem(id, name, condition, result, uses, examples)

        assertEquals(id, item.id)
        assertEquals(name, item.name)
        assertEquals(condition, item.condition)
        assertEquals(result, item.result)
        assertEquals(uses, item.uses)
        assertEquals(examples, item.examples)
    }

    @Test
    fun `Check that comparator works properly`() {
        // Different data
        val item1 = ConditionalItem(1, "Name 1", "Condition 1", "Result 1", "Use 1", "Example 1")
        val item2 = ConditionalItem(2, "Name 2", "Condition 2", "Result 2", "Use 1", "Example 1")
        assertFalse(item1.isSameItemAs(item2))
        assertFalse(item1.hasSameContentsAs(item2))

        // Same Id
        val item3 = ConditionalItem(1, "Name 3", "Condition 3", "Result 3", "Use 1", "Example 1")
        assertTrue(item1.isSameItemAs(item3))
        assertFalse(item1.hasSameContentsAs(item3))

        // Same data
        val item4 = ConditionalItem(1, "Name 1", "Condition 1", "Result 1", "Use 1", "Example 1")
        assertTrue(item1.isSameItemAs(item4))
        assertTrue(item1.hasSameContentsAs(item4))
    }
}
