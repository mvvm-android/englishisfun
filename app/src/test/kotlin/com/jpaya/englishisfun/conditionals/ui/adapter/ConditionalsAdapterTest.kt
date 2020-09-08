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

import android.widget.FrameLayout
import com.jpaya.englishisfun.conditionals.ui.model.ConditionalItem
import com.jpaya.englishisfun.databinding.ConditionalsListItemBinding
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ConditionalsAdapterTest : TestRobolectric(), ConditionalsAdapter.Listener {

    private val itemsList = listOf(
        ConditionalItem(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = "Uses",
            examples = "Examples"
        ),
        ConditionalItem(
            id = 2,
            name = "Another Name",
            condition = "Another Condition",
            result = "Another Result",
            uses = "Another Uses",
            examples = "Another Examples"
        ),
    )
    private lateinit var adapter: ConditionalsAdapter

    @Before
    fun setUp() {
        adapter = ConditionalsAdapter(this)
    }

    @Test
    fun `Check itemCount works properly`() {
        assertEquals(0, adapter.itemCount)
        adapter.submitList(itemsList)
        assertEquals(2, adapter.itemCount)
    }

    @Test
    fun `Check onCreateViewHolder and onBindViewHolder works properly`() {
        adapter.submitList(itemsList)

        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        val binding = viewHolder.binding

        assertNotNull(viewHolder)
        assertThat(binding, CoreMatchers.instanceOf(ConditionalsListItemBinding::class.java))

        adapter.onBindViewHolder(viewHolder, 1)
        assertEquals("Another Name", binding.name.text.toString())
        assertEquals("Another Condition", binding.condition.text.toString())
        assertEquals("Another Result", binding.result.text.toString())
        assertEquals("Another Uses", binding.uses.text.toString())
        assertEquals("Another Examples", binding.examples.text.toString())
    }

    override fun onItemSelected(id: Long) {}
}
