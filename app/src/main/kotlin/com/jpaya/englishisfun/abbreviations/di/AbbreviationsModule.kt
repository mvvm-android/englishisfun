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

package com.jpaya.englishisfun.abbreviations.di

import com.jpaya.englishisfun.abbreviations.AbbreviationsListViewModel
import com.jpaya.englishisfun.abbreviations.firestore.FireStoreClient
import com.jpaya.englishisfun.abbreviations.adapter.AbbreviationsListAdapter
import com.jpaya.englishisfun.abbreviations.paging.AbbreviationsPageDataSource
import com.jpaya.englishisfun.abbreviations.paging.AbbreviationsPageDataSourceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * Class that provides abbreviations-related dependencies to the hilt dependency graph [FragmentComponent].
 * All dependencies provided by this class will be considered as fragment-level properties.
 */
@Module
@InstallIn(FragmentComponent::class)
class AbbreviationsModule {

    /**
     * Create a provider method binding for [AbbreviationsPageDataSource].
     *
     * @return Instance of data source.
     * @see Provides
     */
    @Provides
    fun providesAbbreviationsPageDataSource(fireStoreClient: FireStoreClient) =
        AbbreviationsPageDataSource(
            fireStoreClient = fireStoreClient
        )

    @Provides
    fun providesAbbreviationsListViewModel(dataSourceFactory: AbbreviationsPageDataSourceFactory) =
        AbbreviationsListViewModel(
            dataSourceFactory = dataSourceFactory
        )

    /**
     * Create a provider method binding for [AbbreviationsListAdapter].
     *
     * @return Instance of adapter.
     * @see Provides
     */
    @Provides
    fun providesAbbreviationsListAdapter(viewModel: AbbreviationsListViewModel) =
        AbbreviationsListAdapter(viewModel)
}
