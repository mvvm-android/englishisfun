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

package com.jpaya.englishisfun.conditionals.mapper

import com.jpaya.englishisfun.conditionals.data.db.ConditionalRoomItem
import com.jpaya.englishisfun.conditionals.data.network.model.ConditionalsNetworkItem
import com.jpaya.englishisfun.conditionals.domain.Conditional
import com.jpaya.englishisfun.conditionals.ui.model.ConditionalItem

fun Conditional.toRoomItem() = ConditionalRoomItem(
    id = id,
    name = name,
    condition = condition,
    result = result,
    uses = uses,
    examples = examples
)

fun ConditionalRoomItem.toDomain() = Conditional(
    id = id,
    name = name,
    condition = condition,
    result = result,
    uses = uses,
    examples = examples
)

fun ConditionalsNetworkItem.toDomain() = Conditional(
    id = id,
    name = name,
    condition = condition,
    result = result,
    uses = uses,
    examples = examples
)

fun Conditional.toPresentation() = ConditionalItem(
    id = id,
    name = name,
    condition = condition,
    result = result,
    uses = uses.joinToString(separator = "\n"),
    examples = examples.joinToString(separator = "\n")
)
