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

package com.jpaya.englishisfun.phrasals.data.db

import com.jpaya.base.extensions.encloseToLikeQuery
import com.jpaya.englishisfun.phrasals.domain.Phrasal
import com.jpaya.englishisfun.phrasals.mapper.toDomain
import com.jpaya.englishisfun.phrasals.mapper.toRoomItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseDataSource @Inject constructor(
    private val dao: PhrasalsDao
) {

    suspend fun all(): List<Phrasal> = dao.all().map { it.toDomain() }

    suspend fun count() = dao.count()

    suspend fun save(item: Phrasal) = dao.save(item.toRoomItem())

    suspend fun save(items: List<Phrasal>) {
        val objects = mutableListOf<PhrasalRoomItem>()
        items.forEach {
            objects.add(it.toRoomItem())
        }
        dao.save(objects)
    }

    suspend fun search(filter: String): List<Phrasal> = dao.search(filter.encloseToLikeQuery()).map { it.toDomain() }

    suspend fun delete(id: Long) = dao.delete(id)

    suspend fun delete() = dao.delete()
}