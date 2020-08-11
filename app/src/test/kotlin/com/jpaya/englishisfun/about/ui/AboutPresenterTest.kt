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

package com.jpaya.englishisfun.about.ui

import com.jpaya.base.utils.VersioningUtilsImpl
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AboutPresenterTest {

    companion object {
        private const val MOCK_VERSION_NAME = "1.0"
        private const val MOCK_VERSION_CODE = 1
    }

    private lateinit var versioningUtils: VersioningUtilsImpl
    private lateinit var presenter: AboutPresenter

    @Before
    fun setUp() {
        versioningUtils = mock()
        presenter = AboutPresenter(versioningUtils)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getVersion works properly`() = runBlocking {
        whenever(versioningUtils.versionName()).doReturn(MOCK_VERSION_NAME)
        whenever(versioningUtils.versionCode()).doReturn(MOCK_VERSION_CODE)

        assertEquals("1.0 (1)", presenter.getVersion())
    }
}
