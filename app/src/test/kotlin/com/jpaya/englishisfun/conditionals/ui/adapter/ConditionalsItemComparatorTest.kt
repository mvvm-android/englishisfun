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

package com.jpaya.englishisfun.conditionals.ui.adapter

import com.jpaya.englishisfun.conditionals.ui.ConditionalsListPresenter
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ConditionalsItemComparatorTest {

    private lateinit var comparator: ConditionalsItemComparator

    @Before
    fun setUp() {
        comparator = ConditionalsItemComparator
    }

    @Test
    fun `Check that ConditionalsItemComparator works properly`() {
        // Different data
        val item1 = ConditionalsListPresenter.ConditionalsItem(
            1, "Name 1", "Condition 1", "Result 1", mutableListOf("Use 1"), mutableListOf("Example 1")
        )
        val item2 = ConditionalsListPresenter.ConditionalsItem(
            2, "Name 2", "Condition 2", "Result 2", mutableListOf("Use 1"), mutableListOf("Example 1")
        )
        assertFalse(comparator.areItemsTheSame(item1, item2))
        assertFalse(comparator.areContentsTheSame(item1, item2))

        // Same Id
        val item3 = ConditionalsListPresenter.ConditionalsItem(
            1, "Name 3", "Condition 3", "Result 3", mutableListOf("Use 1"), mutableListOf("Example 1")
        )
        assertTrue(comparator.areItemsTheSame(item1, item3))
        assertFalse(comparator.areContentsTheSame(item1, item3))

        // Same data
        val item4 = ConditionalsListPresenter.ConditionalsItem(
            1, "Name 1", "Condition 1", "Result 1", mutableListOf("Use 1"), mutableListOf("Example 1")
        )
        assertTrue(comparator.areItemsTheSame(item1, item4))
        assertTrue(comparator.areContentsTheSame(item1, item4))
    }
}
