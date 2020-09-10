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

package com.jpaya.englishisfun.data.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FireStoreClientTest {

    private lateinit var fireStore: FirebaseFirestore
    private lateinit var client: FireStoreClient

    @Before
    fun setUp() {
        fireStore = mock()
        client = FireStoreClient(fireStore)
    }

    @Test
    fun initShouldInitialiseProperly() {
        assertEquals(fireStore, client.fireStore)
    }

    @ExperimentalCoroutinesApi
    @Test(expected = Exception::class)
    fun abbreviations() = runBlockingTest {
        val collection: CollectionReference = mock()
        doReturn(collection).whenever(fireStore).collection("")

        val document: DocumentReference = mock()
        doReturn(document).whenever(collection).document("")

        val task: Task<DocumentSnapshot> = mock()
        doReturn(task).whenever(document).get()

        doReturn(true).whenever(task).isComplete
//        val snapshot: DocumentSnapshot = mock()
//        doReturn(snapshot).whenever(task).await()

        client.abbreviations()
    }
}
