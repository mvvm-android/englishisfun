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

package com.jpaya.englishisfun.conditionals.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class ConditionalTest {

    @Test
    fun initShouldInitialiseProperly() {
        val id: Long = 1
        val name = "Name"
        val condition = "Condition"
        val result = "Result"
        val uses = mutableListOf("Use 1")
        val examples = mutableListOf("Example 1")
        val conditionals = Conditional(
            id = id,
            name = name,
            condition = condition,
            result = result,
            uses = uses,
            examples = examples
        )

        assertEquals(id, conditionals.id)
        assertEquals(name, conditionals.name)
        assertEquals(condition, conditionals.condition)
        assertEquals(result, conditionals.result)
        assertEquals(uses, conditionals.uses)
        assertEquals(examples, conditionals.examples)
    }
}
