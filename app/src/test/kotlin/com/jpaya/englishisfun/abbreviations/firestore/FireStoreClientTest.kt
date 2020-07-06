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

package com.jpaya.englishisfun.abbreviations.firestore

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.jpaya.base.firebase.FireStoreProperties
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FireStoreClientTest {

    private lateinit var client: FireStoreClient

    private lateinit var fireStore: FirebaseFirestore
    private lateinit var properties: FireStoreProperties

    @Before
    fun setUp() {
        fireStore = mock()
        properties = mock()

        client = FireStoreClient(
            fireStore,
            properties
        )
    }

    @Test
    fun initShouldInitialiseProperly() {
        assertEquals(fireStore, client.fireStore)
        assertEquals(properties, client.properties)
    }

    @ExperimentalCoroutinesApi
    @Test(expected = Exception::class)
    fun abbreviations() = runBlockingTest {
        doReturn("").whenever(properties).getAbbreviationCollectionName()
        doReturn("").whenever(properties).getAbbreviationDocumentName()

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
