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

package com.jpaya.englishisfun.phrasals.mapper

import com.jpaya.englishisfun.phrasals.data.db.PhrasalRoomItem
import com.jpaya.englishisfun.phrasals.data.network.model.PhrasalNetworkItem
import com.jpaya.englishisfun.phrasals.domain.Phrasal
import com.jpaya.englishisfun.phrasals.ui.model.PhrasalItem

fun Phrasal.toRoomItem() = PhrasalRoomItem(
    id = id,
    verb = verb,
    definitions = definitions
)

fun PhrasalRoomItem.toDomain() = Phrasal(
    id = id,
    verb = verb,
    definitions = definitions
)

fun PhrasalNetworkItem.toDomain() = Phrasal(
    id = id,
    verb = verb,
    definitions = definitions
)

fun Phrasal.toPresentation() = PhrasalItem(
    id = id,
    verb = verb,
    definitions = definitions
)
