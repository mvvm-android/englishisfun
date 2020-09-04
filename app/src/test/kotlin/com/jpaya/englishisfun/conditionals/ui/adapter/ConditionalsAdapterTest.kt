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
import com.jpaya.base.testutils.TestRobolectric
import com.jpaya.englishisfun.conditionals.ui.model.ConditionalItem
import com.jpaya.englishisfun.databinding.ConditionalsListItemBinding
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ConditionalsAdapterTest : TestRobolectric(), ConditionalsAdapter.Listener {

    private lateinit var adapter: ConditionalsAdapter

    @Before
    fun setUp() {
        adapter = ConditionalsAdapter(this)
    }

    @Test
    fun `Check onCreateViewHolder works properly`() {
        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        val binding = viewHolder.binding

        assertNotNull(viewHolder)
        assertThat(binding, CoreMatchers.instanceOf(ConditionalsListItemBinding::class.java))

        // Check bind works properly
        val item = ConditionalItem(
            id = 1,
            name = "Name",
            condition = "Condition",
            result = "Result",
            uses = "Uses",
            examples = "Examples"
        )
        viewHolder.bind(item)

        assertEquals(item.name, binding.name.text.toString())
        assertEquals(item.condition, binding.condition.text.toString())
        assertEquals(item.result, binding.result.text.toString())
        assertEquals(item.uses, binding.uses.text.toString())
        assertEquals(item.examples, binding.examples.text.toString())
    }

    override fun onItemSelected(id: Long) {}
}
