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

package com.jpaya.englishisfun.phrasals.ui.adapter

import android.widget.FrameLayout
import com.jpaya.englishisfun.databinding.PhrasalsListItemBinding
import com.jpaya.englishisfun.phrasals.ui.model.PhrasalItem
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PhrasalsAdapterTest : TestRobolectric() {

    private val ITEMS_LIST = listOf(
        PhrasalItem(
            id = 1,
            verb = "Verb",
            definitions = "Definitions"
        ),
        PhrasalItem(
            id = 2,
            verb = "Another verb",
            definitions = "Another definition"
        ),
    )
    private lateinit var adapter: PhrasalsAdapter

    @Before
    fun setUp() {
        adapter = PhrasalsAdapter()
    }

    @Test
    fun `Check itemCount works properly`() {
        assertEquals(0, adapter.itemCount)
        adapter.submitList(ITEMS_LIST)
        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun `Check getSectionName works properly`() {
        adapter.submitList(ITEMS_LIST)
        assertEquals("V", adapter.getSectionName(0))
        assertEquals("A", adapter.getSectionName(1))
    }

    @Test
    fun `Check onCreateViewHolder and onBindViewHolder works properly`() {
        adapter.submitList(ITEMS_LIST)

        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        val binding = viewHolder.binding

        assertNotNull(viewHolder)
        assertThat(binding, CoreMatchers.instanceOf(PhrasalsListItemBinding::class.java))

        adapter.onBindViewHolder(viewHolder, 1)
        assertEquals("Another verb", binding.base.text.toString())
        assertEquals("Another definition", binding.simple.text.toString())
    }
}
