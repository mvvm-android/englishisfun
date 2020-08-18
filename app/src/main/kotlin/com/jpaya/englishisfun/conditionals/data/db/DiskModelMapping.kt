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

package com.jpaya.englishisfun.conditionals.data.db

import com.jpaya.englishisfun.conditionals.domain.Conditionals

fun Conditionals.toRoomItem(): RoomConditionalsItem {
    return RoomConditionalsItem(
        id = id,
        base = base,
        simple = simple,
        participle = participle,
        definitions = definitions
    )
}

fun RoomConditionalsItem.toDomain(): Conditionals {
    return Conditionals(
        id = id,
        base = base,
        simple = simple,
        participle = participle,
        definitions = definitions
    )
}
