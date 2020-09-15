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

package com.jpaya.englishisfun.data.preferences

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.map

object Settings {

    private const val STORE_NAME = "settings"

    // Preferences
    private val APPEARANCE = preferencesKey<String>("appearance")

    // Default Values
    private const val DEFAULT_APPEARANCE = "auto"

    suspend fun putAppearance(appearance: String, context: Context) = dataStore(context).edit { it[APPEARANCE] = appearance }

    fun getAppearance(context: Context) = dataStore(context).data.map { it[APPEARANCE] ?: DEFAULT_APPEARANCE }

    private fun dataStore(context: Context) = context.createDataStore(STORE_NAME)
}
