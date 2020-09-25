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

package com.jpaya.englishisfun.statives.data.db

import com.jpaya.englishisfun.statives.domain.Stative
import com.jpaya.englishisfun.statives.mapper.toDomain
import com.jpaya.englishisfun.statives.mapper.toRoomItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseDataSource @Inject constructor(
    private val dao: StativesDao
) {

    suspend fun all() = dao.all().map { it.toDomain() }

    suspend fun count() = dao.count()

    suspend fun save(item: Stative) = dao.save(item.toRoomItem())

    suspend fun saveAll(items: List<Stative>) = dao.save(items.map { it.toRoomItem() })

    suspend fun delete(id: Long) = dao.delete(id)

    suspend fun deleteAll() = dao.delete()
}
