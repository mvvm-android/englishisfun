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

package com.jpaya.englishisfun.extensions

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class DebouncingQueryTextListener(
    lifecycleOwner: LifecycleOwner,
    private val onDebouncingQueryTextChange: (String?) -> Unit
) : SearchView.OnQueryTextListener {

    companion object {
        private const val DEBOUNCE_PERIOD: Long = 500
    }

    private val coroutineScope = lifecycleOwner.lifecycleScope
    private var searchJob: Job? = null

    override fun onQueryTextSubmit(query: String?): Boolean = false

    override fun onQueryTextChange(newText: String?): Boolean {
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            newText?.let {
                delay(DEBOUNCE_PERIOD)
                onDebouncingQueryTextChange(newText)
            }
        }
        return false
    }
}
