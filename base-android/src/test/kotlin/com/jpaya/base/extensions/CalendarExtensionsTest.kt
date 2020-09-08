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

package com.jpaya.base.extensions

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar
import kotlin.collections.HashMap

class CalendarExtensionsTest {

    companion object {
        private val TIMES: HashMap<Int, Boolean> = hashMapOf(
            0 to true,
            1 to true,
            2 to true,
            3 to true,
            4 to true,
            5 to true,
            6 to false,
            7 to false,
            8 to false,
            9 to false,
            10 to false,
            11 to false,
            12 to false,
            13 to false,
            14 to false,
            15 to false,
            16 to false,
            17 to false,
            18 to false,
            19 to true,
            20 to true,
            21 to true,
            22 to true,
            23 to true
        )
    }

    @Test
    fun `Check isNightTime works properly`() {
        TIMES.forEach { (hour, expectedResult) ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            assertEquals(expectedResult, calendar.isNightTime())
        }
    }
}
