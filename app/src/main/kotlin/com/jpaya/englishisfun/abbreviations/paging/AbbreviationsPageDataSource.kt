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

package com.jpaya.englishisfun.abbreviations.paging

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.jpaya.base.network.NetworkState
import com.jpaya.englishisfun.abbreviations.firestore.FireStoreClient
import com.jpaya.englishisfun.abbreviations.model.AbbreviationItem
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Incremental data loader for page-keyed content, where requests return keys for next/previous
 * pages. Obtaining paginated the abbreviations.
 *
 * @see PageKeyedDataSource
 */
open class AbbreviationsPageDataSource @Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    val fireStoreClient: FireStoreClient
) : PageKeyedDataSource<Int, AbbreviationItem>() {

    @VisibleForTesting(otherwise = PRIVATE)
    var networkState = MutableLiveData<NetworkState>()

    @VisibleForTesting(otherwise = PRIVATE)
    var retry: (() -> Unit)? = null

    /**
     * Load initial data.
     *
     * @param params Parameters for initial load, including requested load size.
     * @param callback Callback that receives initial load data.
     * @see PageKeyedDataSource.loadInitial
     */
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, AbbreviationItem>) {
        networkState.postValue(NetworkState.Loading())
        MainScope().launch(
            CoroutineExceptionHandler { _, _ ->
                retry = {
                    loadInitial(params, callback)
                }
                networkState.postValue(NetworkState.Error())
            }
        ) {
            val response = fireStoreClient.abbreviations()
            if (response != null)
                callback.onResult(response.abbreviations, null, null)
            networkState.postValue(
                NetworkState.Success(
                    isAdditional = false,
                    isEmptyResponse = response == null || response.abbreviations.isEmpty()
                )
            )
        }
    }

    /**
     * Append page with the key specified by [LoadParams.key].
     *
     * @param params Parameters for the load, including the key for the new page, and requested
     * load size.
     * @param callback Callback that receives loaded data.
     * @see PageKeyedDataSource.loadAfter
     */
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, AbbreviationItem>) {
        // Ignored, since we load all list at once
    }

    /**
     * Prepend page with the key specified by [LoadParams.key]
     *
     * @param params Parameters for the load, including the key for the new page, and requested
     * load size.
     * @param callback Callback that receives loaded data.
     * @see PageKeyedDataSource.loadBefore
     */
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, AbbreviationItem>) {
        // Ignored, since we load all list at once
    }

    /**
     * Force retry last fetch operation in case it has ever been previously executed.
     */
    fun retry() {
        retry?.invoke()
    }
}
