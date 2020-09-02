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

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

/**
 * Defines the data-access object for [StativeRoomItem].
 */
@Dao
interface StativeDao {

    /**
     * Returns a list with all the entities.
     */
    @Query("SELECT * FROM statives")
    suspend fun all(): List<StativeRoomItem>

    /**
     * Returns the number of entities.
     */
    @Query("SELECT count(*) FROM statives")
    suspend fun count(): Int

    /**
     * Persists an entity.
     */
    @Insert(onConflict = REPLACE)
    suspend fun save(item: StativeRoomItem)

    /**
     * Persists a list of entities.
     */
    @Insert(onConflict = REPLACE)
    suspend fun save(items: List<StativeRoomItem>)

    /**
     * Searches entities with the specified filter.
     */
    @Query("SELECT * FROM statives WHERE category LIKE :filter")
    suspend fun search(filter: String): List<StativeRoomItem>

    /**
     * Deletes an entity by its id.
     */
    @Query("DELETE FROM statives WHERE id = :id")
    suspend fun delete(id: Long)

    /**
     * Deletes all the entities.
     */
    @Query("DELETE FROM statives")
    suspend fun delete()
}
