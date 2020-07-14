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

package com.jpaya.englishisfun.irregulars.di

import com.jpaya.englishisfun.firestore.FireStoreClient
import com.jpaya.englishisfun.irregulars.data.network.NetworkDataSource
import com.jpaya.englishisfun.irregulars.domain.IrregularsInteractor
import com.jpaya.englishisfun.irregulars.ui.IrregularsListPresenter
import com.jpaya.englishisfun.irregulars.ui.IrregularsListViewModel
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
class IrregularsModule {

    /**
     * Create a provider method binding for [IrregularsListViewModel].
     *
     * @return Instance of view model.
     */
    @Provides
    fun providesListViewModel(presenter: IrregularsListPresenter): IrregularsListViewModel =
        IrregularsListViewModel(presenter)

    /**
     * Create a provider method binding for [IrregularsListPresenter].
     *
     * @return Instance of presenter.
     */
    @Provides
    fun providesListPresenter(interactor: IrregularsInteractor): IrregularsListPresenter =
        IrregularsListPresenter(interactor)

    /**
     * Create a provider method binding for [IrregularsInteractor].
     *
     * @return Instance of interactor.
     */
    @Provides
    fun providesIrregularsInteractor(dataSource: NetworkDataSource): IrregularsInteractor =
        IrregularsInteractor(dataSource)

    /**
     * Create a provider method binding for [NetworkDataSource].
     *
     * @return Instance of data source.
     */
    @Provides
    fun providesNetworkDataSource(fireStoreClient: FireStoreClient): NetworkDataSource =
        NetworkDataSource(fireStoreClient)
}
