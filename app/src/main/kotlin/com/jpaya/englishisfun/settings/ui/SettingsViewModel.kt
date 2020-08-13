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

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.jpaya.base.utils.ThemeUtils
import com.jpaya.englishisfun.R

class SettingsViewModel @ViewModelInject constructor(
    private val themeUtils: ThemeUtils
) : RainbowCakeViewModel<SettingsViewState>(Loaded) {

    fun setAppearance(context: Context, appearance: String) {
        when (appearance) {
            // TODO DETECT
            context.getString(R.string.setting_appearance_option_auto_value) -> themeUtils.setNightMode(true)
            context.getString(R.string.setting_appearance_option_dark_value) -> themeUtils.setNightMode(true)
            context.getString(R.string.setting_appearance_option_light_value) -> themeUtils.setNightMode(false)
        }
    }
}
