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

import java.util.Calendar

private const val NIGHT_TIME_START_HOUR = 18
private const val NIGHT_TIME_END_HOUR = 6

/**
 *  Checks if a Calendar object has a night time.
 *
 *  @return true if the Calendar is at night, false otherwise.
 */
fun Calendar.isNightTime(): Boolean {
    val hour = get(Calendar.HOUR_OF_DAY)
    return hour < NIGHT_TIME_END_HOUR || hour > NIGHT_TIME_START_HOUR
}
