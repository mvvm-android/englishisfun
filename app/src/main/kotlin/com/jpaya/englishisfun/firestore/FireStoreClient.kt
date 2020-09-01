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

import androidx.annotation.VisibleForTesting
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jpaya.englishisfun.abbreviations.data.network.model.AbbreviationsResponse
import com.jpaya.englishisfun.idioms.data.network.model.IdiomsResponse
import com.jpaya.englishisfun.conditionals.data.network.model.ConditionalsResponse
import com.jpaya.englishisfun.irregulars.data.network.model.IrregularsResponse
import com.jpaya.englishisfun.phrasals.data.network.model.PhrasalsResponse
import com.jpaya.englishisfun.statives.data.network.model.StativesResponse
import com.jpaya.englishisfun.suggestions.data.network.model.SuggestionsContent
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

/**
 * Class to unify all FireStore operations.
 */
class FireStoreClient @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fireStore: FirebaseFirestore
) {

    companion object {
        private const val ABBREVIATION_COLLECTION = "abbreviation"
        private const val ABBREVIATION_DOCUMENT = "list"

        private const val IDIOM_COLLECTION = "idiom"
        private const val IDIOM_DOCUMENT = "list"

        private const val IRREGULAR_COLLECTION = "irregular"
        private const val IRREGULAR_DOCUMENT = "list"

        private const val CONDITIONAL_COLLECTION = "conditional"
        private const val CONDITIONAL_DOCUMENT = "list"

        private const val STATIVE_COLLECTION = "stative"
        private const val STATIVE_DOCUMENT = "list"

        private const val SUGGESTION_COLLECTION = "suggestion"
    }

    /**
     * Function to obtain all abbreviations.
     */
    suspend fun abbreviations() = execute(
        fireStore.collection(ABBREVIATION_COLLECTION).document(ABBREVIATION_DOCUMENT),
        AbbreviationsResponse::class.java
    )

    /**
     * Function to obtain all idioms.
     */
    suspend fun idioms() = execute(
        fireStore.collection(IDIOM_COLLECTION).document(IDIOM_DOCUMENT),
        IdiomsResponse::class.java
    )

    /**
     * Function to obtain all irregulars.
     */
    suspend fun irregulars() = execute(
        fireStore.collection(IRREGULAR_COLLECTION).document(IRREGULAR_DOCUMENT),
        IrregularsResponse::class.java
    )

    /**
     * Function to obtain all conditionals.
     */
    suspend fun conditionals() = execute(
        fireStore.collection(CONDITIONAL_COLLECTION).document(CONDITIONAL_DOCUMENT),
        ConditionalsResponse::class.java
    )

    /**
     * Function to obtain all stative verbs.
     */
    suspend fun statives() = execute(
        fireStore.collection(STATIVE_COLLECTION).document(STATIVE_DOCUMENT),
        StativesResponse::class.java
    )

    /**
     * Function to obtain all phrasals.
     */
    suspend fun phrasals() = execute(
        fireStore.collection("phrasal").document("list"),
        PhrasalsResponse::class.java
    )

    /**
     * Function to save a suggestion.
     */
    suspend fun sendSuggestion(data: SuggestionsContent) {
        fireStore.collection(SUGGESTION_COLLECTION)
            .add(data)
            .addOnSuccessListener {
                Timber.d("DocumentSnapshot written with ID: ${it.id}")
            }
            .addOnFailureListener {
                Timber.d("Error adding document")
            }
            .await()
    }

    private suspend fun <T> execute(reference: DocumentReference, valueType: Class<T>): T? =
        reference.get().await().toObject(valueType)
}
