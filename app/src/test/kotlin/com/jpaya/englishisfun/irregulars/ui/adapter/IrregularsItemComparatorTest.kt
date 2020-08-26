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

package com.jpaya.englishisfun.irregulars.ui.adapter

import com.jpaya.englishisfun.irregulars.ui.IrregularsListPresenter
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class IrregularsItemComparatorTest {

    private lateinit var comparator: IrregularsItemComparator

    @Before
    fun setUp() {
        comparator = IrregularsItemComparator
    }

    @Test
    fun `Check that IrregularsItemComparator works properly`() {
        // Different data
        val item1 = IrregularsListPresenter.IrregularsItem(1, "Base 1", "Simple 1", "Participle 1", "Definitions 1")
        val item2 = IrregularsListPresenter.IrregularsItem(2, "Base 2", "Simple 2", "Participle 2", "Definitions 2")
        assertFalse(comparator.areItemsTheSame(item1, item2))
        assertFalse(comparator.areContentsTheSame(item1, item2))

        // Same Id
        val item3 = IrregularsListPresenter.IrregularsItem(1, "Base 3", "Simple 3", "Participle 3", "Definitions 3")
        assertTrue(comparator.areItemsTheSame(item1, item3))
        assertFalse(comparator.areContentsTheSame(item1, item3))

        // Same data
        val item4 = IrregularsListPresenter.IrregularsItem(1, "Base 1", "Simple 1", "Participle 1", "Definitions 1")
        assertTrue(comparator.areItemsTheSame(item1, item4))
        assertTrue(comparator.areContentsTheSame(item1, item4))
    }
}
