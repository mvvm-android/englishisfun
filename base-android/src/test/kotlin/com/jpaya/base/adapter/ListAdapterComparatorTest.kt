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

package com.jpaya.base.adapter

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ListAdapterComparatorTest {

    private lateinit var adapterComparator: ListAdapterComparator<SampleClass>

    @Before
    fun setUp() {
        adapterComparator = ListAdapterComparator()
    }

    @Test
    fun `Check adapter comparator works properly`() {
        // Different data
        val item1 = SampleClass(1, "Name 1")
        val item2 = SampleClass(2, "Name 2")
        assertFalse(adapterComparator.areItemsTheSame(item1, item2))
        assertFalse(adapterComparator.areContentsTheSame(item1, item2))

        // Same Id
        val item3 = SampleClass(1, "Name 3")
        assertTrue(adapterComparator.areItemsTheSame(item1, item3))
        assertFalse(adapterComparator.areContentsTheSame(item1, item3))

        // Same data
        val item4 = SampleClass(1, "Name 1")
        assertTrue(adapterComparator.areItemsTheSame(item1, item4))
        assertTrue(adapterComparator.areContentsTheSame(item1, item4))
    }

    data class SampleClass(
        val id: Long,
        val name: String
    ) : GenericAdapterComparator<SampleClass> {
        override fun isSameItemAs(item: SampleClass) = id == item.id

        override fun hasSameContentsAs(item: SampleClass) = this == item
    }
}
