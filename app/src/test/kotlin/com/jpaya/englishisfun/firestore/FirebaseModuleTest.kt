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

package com.jpaya.englishisfun.firestore

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class FirebaseModuleTest {

    private lateinit var module: FirebaseModule

    @Before
    fun setUp() {
        module = FirebaseModule()
    }

    @Test
    fun verifyProvidedFirebaseFireStore() {
        mockkStatic(FirebaseFirestore::class)
        every { FirebaseFirestore.getInstance() } returns mockk()
        assertNotNull(module.provideFirebaseFireStore())
    }

    @Test
    fun verifyProvidedFirebaseAuth() {
        mockkStatic(FirebaseAuth::class)
        every { FirebaseAuth.getInstance() } returns mockk()
        assertNotNull(module.provideFirebaseAuth())
    }

    @Test
    fun verifyProvidedFireStoreProperties() {
        assertNotNull(module.provideFireStoreProperties())
    }
}
