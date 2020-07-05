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

/**
 * Implementation of the interface PackageManagerUtils to obtain the application's version.
 */
class VersioningUtilsImpl(val context: Context) : VersioningUtils {

    /**
     * Obtains the version name of the application.
     */
    override fun versionName(): String? = packageInfo().versionName

    /**
     * Obtains the version code of the application.
     */
    override fun versionCode(): Int = packageInfo().versionCode

    private fun packageInfo() = context.packageManager.getPackageInfo(context.packageName, 0)
}
