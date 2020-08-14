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

import androidx.appcompat.app.AppCompatActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class VersioningUtilsImplTest : TestRobolectric() {

    @get:Rule
    val rule = ActivityScenarioRule(AppCompatActivity::class.java)
    private lateinit var scenario: ActivityScenario<AppCompatActivity>

    private lateinit var versioningUtils: VersioningUtils

    @Before
    fun setUp() {
        scenario = rule.scenario
        scenario.onActivity {
            versioningUtils = VersioningUtilsImpl(it)
        }
    }

    @Test
    fun verifyProvidedVersionName() {
        assertNull(versioningUtils.versionName())
    }

    @Test
    fun verifyProvidedVersionCode() {
        assertNotNull(versioningUtils.versionCode())
    }
}
