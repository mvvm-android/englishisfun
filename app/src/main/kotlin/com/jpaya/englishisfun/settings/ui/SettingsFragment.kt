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

package com.jpaya.englishisfun.settings.ui

import android.os.Bundle
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.jpaya.base.utils.ThemeUtils
import com.jpaya.englishisfun.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : PreferenceFragmentCompat() {

    @Inject
    lateinit var themeUtils: ThemeUtils

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_fragment, rootKey)

        findPreference<ListPreference>(getString(R.string.setting_appearance_key))
            ?.setOnPreferenceChangeListener { _, newValue ->
                when (newValue) {
                    // TODO DETECT
                    getString(R.string.setting_appearance_option_auto_value) -> themeUtils.setNightMode(true)
                    getString(R.string.setting_appearance_option_dark_value) -> themeUtils.setNightMode(true)
                    getString(R.string.setting_appearance_option_light_value) -> themeUtils.setNightMode(false)
                }
                true
            }
    }
}
