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

package com.jpaya.englishisfun.suggestions.di

import com.jpaya.englishisfun.firestore.FireStoreClient
import com.jpaya.englishisfun.suggestions.data.network.NetworkDataSource
import com.jpaya.englishisfun.suggestions.domain.SuggestionsInteractor
import com.jpaya.englishisfun.suggestions.ui.SuggestionsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

/**
 * Class that provides irregulars-related dependencies to the hilt dependency graph [FragmentComponent].
 * All dependencies provided by this class will be considered as fragment-level properties.
 */
@Module
@InstallIn(FragmentComponent::class)
class SuggestionsModule {

    /**
     * Create a provider method binding for [SuggestionsPresenter].
     *
     * @return Instance of presenter.
     */
    @Provides
    fun providesPresenter(interactor: SuggestionsInteractor) = SuggestionsPresenter(interactor)

    /**
     * Create a provider method binding for [SuggestionsInteractor].
     *
     * @return Instance of interactor.
     */
    @Provides
    fun providesInteractor(network: NetworkDataSource) = SuggestionsInteractor(network)

    /**
     * Create a provider method binding for [NetworkDataSource].
     *
     * @return Instance of data source.
     */
    @Provides
    fun providesNetworkDataSource(client: FireStoreClient) = NetworkDataSource(client)
}
