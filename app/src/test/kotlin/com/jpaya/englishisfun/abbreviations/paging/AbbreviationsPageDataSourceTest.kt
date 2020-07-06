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

class AbbreviationsPageDataSourceTest {

//    private lateinit var dataSource: AbbreviationsPageDataSource
//
//    private lateinit var fireStoreClient: FireStoreClient
//
//    @Before
//    fun setUp() {
//        fireStoreClient = mock()
//    }
//
//    @ExperimentalCoroutinesApi
//    @Test
//    fun loadInitial_withNullList() = runBlockingTest {
//        dataSource = AbbreviationsPageDataSource(fireStoreClient)
//        dataSource.networkState = mock()
//
//        doReturn(null).whenever(fireStoreClient).abbreviations()
//
//        val callback: PageKeyedDataSource.LoadInitialCallback<Int, AbbreviationItem> = mock()
//        dataSource.loadInitial(mock(), callback)
//
//        verify(dataSource.networkState).postValue(NetworkState.Loading())
//        verify(callback, never()).onResult(any(), any(), any())
//    }
//
//    @ExperimentalCoroutinesApi
//    @Test
//    fun loadInitial_withEmptyList() = runBlockingTest {
//        dataSource = AbbreviationsPageDataSource(fireStoreClient)
//        dataSource.networkState = mock()
//
//        val expectedResult = AbbreviationsDocument().apply {
//            abbreviations = listOf()
//        }
//        doReturn(expectedResult).whenever(fireStoreClient).abbreviations()
//
//        val callback: PageKeyedDataSource.LoadInitialCallback<Int, AbbreviationItem> = mock()
//        dataSource.loadInitial(mock(), callback)
//
//        verify(dataSource.networkState).postValue(NetworkState.Loading())
//        verify(callback).onResult(expectedResult.abbreviations, null, null)
//        verify(dataSource.networkState).postValue(NetworkState.Success(isAdditional = false, isEmptyResponse = true))
//    }
//
//    @ExperimentalCoroutinesApi
//    @Test
//    fun loadInitial_withNotEmptyList() = runBlockingTest {
//        dataSource = AbbreviationsPageDataSource(fireStoreClient)
//        dataSource.networkState = mock()
//
//        val expectedResult = AbbreviationsDocument().apply {
//            abbreviations = listOf(
//                AbbreviationItem().apply {
//                    id = 1
//                    abbr = "LOL"
//                    desc = "Laugh Out Loud"
//                }
//            )
//        }
//        doReturn(expectedResult).whenever(fireStoreClient).abbreviations()
//
//        val callback: PageKeyedDataSource.LoadInitialCallback<Int, AbbreviationItem> = mock()
//        dataSource.loadInitial(mock(), callback)
//
//        verify(dataSource.networkState).postValue(NetworkState.Loading())
//        verify(callback).onResult(expectedResult.abbreviations, null, null)
//        verify(dataSource.networkState).postValue(NetworkState.Success(isAdditional = false, isEmptyResponse = false))
//
//        dataSource.retry() // This retry should do nothing as the operation has succeeded
//
//        verify(dataSource.networkState).postValue(NetworkState.Loading())
//        verify(callback).onResult(expectedResult.abbreviations, null, null)
//        verify(dataSource.networkState).postValue(NetworkState.Success(isAdditional = false, isEmptyResponse = false))
//    }
//
//    @ExperimentalCoroutinesApi
//    @Test
//    fun loadInitial_withNetworkError() = runBlockingTest {
//        dataSource = AbbreviationsPageDataSource(fireStoreClient)
//        dataSource.networkState = mock()
//
//        `when`(fireStoreClient.abbreviations()).thenThrow(RuntimeException())
//
//        val callback: PageKeyedDataSource.LoadInitialCallback<Int, AbbreviationItem> = mock()
//        dataSource.loadInitial(mock(), callback)
//
//        verify(dataSource.networkState).postValue(NetworkState.Loading())
//        verify(callback, never()).onResult(any(), any(), any())
//        verify(dataSource.networkState).postValue(NetworkState.Error())
//
//        dataSource.retry()
//
//        verify(dataSource.networkState, times(2)).postValue(NetworkState.Loading())
//        verify(callback, never()).onResult(any(), any(), any())
//        verify(dataSource.networkState, times(2)).postValue(NetworkState.Error())
//    }
}
