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
