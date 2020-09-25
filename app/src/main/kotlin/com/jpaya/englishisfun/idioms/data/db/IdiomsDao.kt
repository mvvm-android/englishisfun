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

package com.jpaya.englishisfun.idioms.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * Defines the data-access object for [IdiomRoomItem].
 */
@Dao
interface IdiomsDao {

    /**
     * Returns a list with all the entities.
     */
    @Query("SELECT * FROM idioms")
    suspend fun all(): List<IdiomRoomItem>

    /**
     * Returns the number of entities.
     */
    @Query("SELECT count(*) FROM idioms")
    suspend fun count(): Int

    /**
     * Persists an entity.
     */
    @Insert(onConflict = REPLACE)
    suspend fun save(item: IdiomRoomItem)

    /**
     * Persists a list of entities.
     */
    @Insert(onConflict = REPLACE)
    suspend fun save(items: List<IdiomRoomItem>)

    /**
     * Searches entities with the specified filter.
     */
    @Query("SELECT * FROM idioms WHERE idiom LIKE :filter OR description LIKE :filter")
    suspend fun search(filter: String): List<IdiomRoomItem>

    /**
     * Deletes an entity by its id.
     */
    @Query("DELETE FROM idioms WHERE id = :id")
    suspend fun delete(id: Long)

    /**
     * Deletes all the entities.
     */
    @Query("DELETE FROM idioms")
    suspend fun delete()
}
