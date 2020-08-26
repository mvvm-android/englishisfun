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

package com.jpaya.englishisfun.idioms.ui.adapter

import com.jpaya.englishisfun.idioms.ui.IdiomsListPresenter
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class IdiomsItemComparatorTest {

    private lateinit var comparator: IdiomsItemComparator

    @Before
    fun setUp() {
        comparator = IdiomsItemComparator
    }

    @Test
    fun `Check that IdiomsItemComparator works properly`() {
        // Different data
        val item1 = IdiomsListPresenter.IdiomsItem(1, "Idiom 1", "Description 1")
        val item2 = IdiomsListPresenter.IdiomsItem(2, "Idiom 2", "Description 2")
        assertFalse(comparator.areItemsTheSame(item1, item2))
        assertFalse(comparator.areContentsTheSame(item1, item2))

        // Same Id
        val item3 = IdiomsListPresenter.IdiomsItem(1, "Idiom 3", "Description 3")
        assertTrue(comparator.areItemsTheSame(item1, item3))
        assertFalse(comparator.areContentsTheSame(item1, item3))

        // Same data
        val item4 = IdiomsListPresenter.IdiomsItem(1, "Idiom 1", "Description 1")
        assertTrue(comparator.areItemsTheSame(item1, item4))
        assertTrue(comparator.areContentsTheSame(item1, item4))
    }
}
