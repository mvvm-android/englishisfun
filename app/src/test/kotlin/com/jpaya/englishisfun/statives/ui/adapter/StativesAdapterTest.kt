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
        val candyViewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        assertNotNull(candyViewHolder)
        assertThat(candyViewHolder.binding, instanceOf(StativeListItemBinding::class.java))
    }
}
