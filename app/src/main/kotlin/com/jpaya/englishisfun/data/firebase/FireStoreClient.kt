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

import androidx.annotation.VisibleForTesting
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.jpaya.base.exception.Failure
import com.jpaya.base.functional.Either
import com.jpaya.base.functional.Either.Left
import com.jpaya.base.functional.Either.Right
import com.jpaya.englishisfun.abbreviations.data.network.model.AbbreviationsResponse
import com.jpaya.englishisfun.idioms.data.network.model.IdiomsResponse
import com.jpaya.englishisfun.conditionals.data.network.model.ConditionalsResponse
import com.jpaya.englishisfun.irregulars.data.network.model.IrregularsResponse
import com.jpaya.englishisfun.phrasals.data.network.model.PhrasalsResponse
import com.jpaya.englishisfun.statives.data.network.model.StativesResponse
import com.jpaya.englishisfun.suggestions.data.network.model.SuggestionsRequest
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

        private const val PHRASAL_COLLECTION = "phrasal"
        private const val PHRASAL_DOCUMENT = "list"

        private const val SUGGESTION_COLLECTION = "suggestion"
    }

    /**
     * Function to obtain all abbreviations.
     */
    suspend fun abbreviations(): Either<Failure, AbbreviationsResponse> =
        try {
            Right(document(ABBREVIATION_COLLECTION, ABBREVIATION_DOCUMENT).get().await().toObject(AbbreviationsResponse::class.java)!!)
        } catch (e: Exception) {
            Left(Failure.NetworkConnection)
        }

    /**
     * Function to obtain all idioms.
     */
    suspend fun idioms() = execute(document(IDIOM_COLLECTION, IDIOM_DOCUMENT), IdiomsResponse::class.java)

    /**
     * Function to obtain all irregulars.
     */
    suspend fun irregulars() =
        execute(document(IRREGULAR_COLLECTION, IRREGULAR_DOCUMENT), IrregularsResponse::class.java)

    /**
     * Function to obtain all conditionals.
     */
    suspend fun conditionals() =
        execute(document(CONDITIONAL_COLLECTION, CONDITIONAL_DOCUMENT), ConditionalsResponse::class.java)

    /**
     * Function to obtain all stative verbs.
     */
    suspend fun statives() = execute(document(STATIVE_COLLECTION, STATIVE_DOCUMENT), StativesResponse::class.java)

    /**
     * Function to obtain all phrasals.
     */
    suspend fun phrasals() = execute(document(PHRASAL_COLLECTION, PHRASAL_DOCUMENT), PhrasalsResponse::class.java)

    /**
     * Function to save a suggestion.
     */
    suspend fun sendSuggestion(data: SuggestionsRequest) {
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

    private fun document(collection: String, document: String) = fireStore.collection(collection).document(document)

    private suspend fun <T> execute(reference: DocumentReference, valueType: Class<T>): T? =
        try {
            reference.get().await().toObject(valueType)
        } catch (e: Exception) {
            null
        }
}
