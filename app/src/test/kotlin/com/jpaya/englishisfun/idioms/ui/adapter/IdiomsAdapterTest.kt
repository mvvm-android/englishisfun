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

import android.widget.FrameLayout
import com.jpaya.base.testutils.TestRobolectric
import com.jpaya.englishisfun.databinding.IdiomsListItemBinding
import com.jpaya.englishisfun.idioms.ui.model.IdiomItem
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class IdiomsAdapterTest : TestRobolectric(), IdiomsAdapter.Listener {

    private lateinit var adapter: IdiomsAdapter

    @Before
    fun setUp() {
        adapter = IdiomsAdapter(this)
    }

    @Test
    fun `Check onCreateViewHolder works properly`() {
        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        val binding = viewHolder.binding

        assertNotNull(viewHolder)
        assertThat(binding, CoreMatchers.instanceOf(IdiomsListItemBinding::class.java))

        // Check bind works properly
        val item = IdiomItem(
            id = 1,
            idiom = "Idiom",
            description = "Description"
        )
        viewHolder.bind(item)

        assertEquals(item.idiom, binding.idiom.text.toString())
        assertEquals(item.description, binding.description.text.toString())
    }

    override fun onItemSelected(id: Long) {}
}
