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

import android.widget.FrameLayout
import com.jpaya.englishisfun.databinding.IrregularsListItemBinding
import com.jpaya.englishisfun.irregulars.ui.model.IrregularItem
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class IrregularsAdapterTest : TestRobolectric(), IrregularsAdapter.Listener {

    private val itemsList = listOf(
        IrregularItem(
            id = 1,
            base = "Base",
            simple = "Simple",
            participle = "Participle",
            definitions = "Definition"
        ),
        IrregularItem(
            id = 2,
            base = "Another Base",
            simple = "Another Simple",
            participle = "Another participle",
            definitions = "Another definition"
        ),
    )
    private lateinit var adapter: IrregularsAdapter

    @Before
    fun setUp() {
        adapter = IrregularsAdapter(this)
    }

    @Test
    fun `Check itemCount works properly`() {
        assertEquals(0, adapter.itemCount)
        adapter.submitList(itemsList)
        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun `Check getSectionName works properly`() {
        adapter.submitList(itemsList)
        assertEquals("B", adapter.getSectionName(0))
        assertEquals("A", adapter.getSectionName(1))
    }

    @Test
    fun `Check onCreateViewHolder and onBindViewHolder works properly`() {
        adapter.submitList(itemsList)

        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        val binding = viewHolder.binding

        assertNotNull(viewHolder)
        assertThat(binding, CoreMatchers.instanceOf(IrregularsListItemBinding::class.java))

        adapter.onBindViewHolder(viewHolder, 1)
        assertEquals("Another Base", binding.base.text.toString())
        assertEquals("Another Simple", binding.simple.text.toString())
        assertEquals("Another Participle", binding.participle.text.toString())
    }

    override fun onItemSelected(id: Long) {}
}
