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

package com.jpaya.dynamicfeatures.abbreviations.ui

import androidx.annotation.VisibleForTesting
import com.google.firebase.firestore.FirebaseFirestore
import com.jpaya.base.firebase.FireStoreProperties
import com.jpaya.dynamicfeatures.abbreviations.ui.model.AbbreviationsDocument
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FireStoreClient @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fireStore: FirebaseFirestore,
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val properties: FireStoreProperties
) {

    suspend fun abbreviations() = fireStore
        .collection(properties.getAbbreviationCollectionName())
        .document(properties.getAbbreviationDocumentName())
        .get()
        .await()
        .toObject(AbbreviationsDocument::class.java)
}
