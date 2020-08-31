package com.jpaya.englishisfun.abbreviations.ui.model

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AbbreviationItemTest {

    @Test
    fun `Check that comparator works properly`() {
        // Different data
        val item1 = AbbreviationItem(1, "Abbreviation 1", "Description 1")
        val item2 = AbbreviationItem(2, "Abbreviation 2", "Description 2")
        assertFalse(item1.isSameItemAs(item2))
        assertFalse(item1.hasSameContentsAs(item2))

        // Same Id
        val item3 = AbbreviationItem(1, "Abbreviation 3", "Description 3")
        assertTrue(item1.isSameItemAs(item3))
        assertFalse(item1.hasSameContentsAs(item3))

        // Same data
        val item4 = AbbreviationItem(1, "Abbreviation 1", "Description 1")
        assertTrue(item1.isSameItemAs(item4))
        assertTrue(item1.hasSameContentsAs(item4))
    }
}
