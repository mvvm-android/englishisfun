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

package com.jpaya.englishisfun.statives.ui.adapter

import android.widget.FrameLayout
import com.jpaya.englishisfun.databinding.StativeListItemBinding
import com.jpaya.englishisfun.statives.ui.model.StativeItem
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class StativesAdapterTest : TestRobolectric() {

    private val itemsList = listOf(
        StativeItem(
            id = 1,
            category = "Category",
            verbs = mutableListOf("Verb 1")
        ),
        StativeItem(
            id = 2,
            category = "Another category",
            verbs = mutableListOf("Verb 2")
        ),
    )
    private lateinit var adapter: StativesAdapter

    @Before
    fun setUp() {
        adapter = StativesAdapter()
    }

    @Test
    fun `Check itemCount works properly`() {
        assertEquals(0, adapter.itemCount)
        adapter.setData(itemsList)
        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun `Check getSectionName works properly`() {
        adapter.setData(itemsList)
        assertEquals("C", adapter.getSectionName(0))
        assertEquals("A", adapter.getSectionName(1))
    }

    @Test
    fun `Check onCreateViewHolder and onBindViewHolder works properly`() {
        adapter.setData(itemsList)

        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        val binding = viewHolder.binding

        assertNotNull(viewHolder)
        assertThat(binding, CoreMatchers.instanceOf(StativeListItemBinding::class.java))

        adapter.onBindViewHolder(viewHolder, 1)
        assertEquals("Another category", binding.base.text.toString())
        assertEquals("Another category", binding.simple.text.toString())
        assertEquals("Another category", binding.participle.text.toString())
    }
}
