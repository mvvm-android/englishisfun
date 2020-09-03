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
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class StativesAdapterTest : TestRobolectric() {

    private lateinit var adapter: StativesAdapter

    @Before
    fun setUp() {
        adapter = StativesAdapter()
    }

    @Test
    fun `Check onCreateViewHolder works properly`() {
        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        assertNotNull(viewHolder)
        assertThat(viewHolder.binding, instanceOf(StativeListItemBinding::class.java))
    }
}
