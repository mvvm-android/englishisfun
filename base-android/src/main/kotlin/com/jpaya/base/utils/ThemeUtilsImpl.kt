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

package com.jpaya.base.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import java.util.*
import javax.inject.Inject

/**
 * Utils implementation for application theme configuration.
 * @see ThemeUtils
 */
class ThemeUtilsImpl @Inject constructor() : ThemeUtils {

    companion object {
        private const val DELAY_TO_APPLY_THEME = 1000L
        private const val NIGHT_TIME_START_HOUR = 18
        private const val NIGHT_TIME_END_HOUR = 6
    }

    /**
     * Whether the current configuration is a dark theme i.e. in Night configuration.
     */
    private fun isDarkTheme(context: Context) = context.resources.configuration.uiMode and
        Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

    /**
     * Whether the current configuration is a light theme i.e. in Day configuration.
     */
    private fun isLightTheme(context: Context) = !isDarkTheme(context)

    /**
     * Checks the time and determines night time.
     */
    private fun isNightTime(): Boolean {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return hour < NIGHT_TIME_END_HOUR || hour > NIGHT_TIME_START_HOUR
    }

    /**
     * Force [AppCompatDelegate] Mode to night/notnight.
     *
     * @param forceNight Boolean that force night mode otherwise notnight is configured.
     * @param delay Delay to apply mode changes.
     */
    private fun setNightMode(forceNight: Boolean, delay: Long = DELAY_TO_APPLY_THEME) {
        Handler().postDelayed(
            {
                AppCompatDelegate.setDefaultNightMode(
                    if (forceNight) {
                        AppCompatDelegate.MODE_NIGHT_YES
                    } else {
                        AppCompatDelegate.MODE_NIGHT_NO
                    }
                )
            },
            delay
        )
    }

    override fun setAppearance(appearance: String) {
        when (appearance) {
            "auto" -> setNightMode(isNightTime())
            "dark" -> setNightMode(true)
            "light" -> setNightMode(false)
        }
    }
}
