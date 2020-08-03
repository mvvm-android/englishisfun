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

import android.content.Context
import com.jpaya.englishisfun.firestore.FireStoreClient
import com.jpaya.englishisfun.irregulars.data.db.DatabaseDataSource
import com.jpaya.englishisfun.irregulars.data.network.NetworkDataSource
import com.jpaya.englishisfun.irregulars.domain.IrregularsInteractor
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class IrregularsModuleTest {

    private lateinit var module: IrregularsModule

    @Before
    fun setUp() {
        module = IrregularsModule()
    }

    @Test
    fun `Check provided list presenter`() {
        val interactor: IrregularsInteractor = mock()
        val presenter = module.providesListPresenter(interactor)
        assertNotNull(presenter)
    }

    @Test
    fun `Check provided interactor`() {
        val network: NetworkDataSource = mock()
        val database: DatabaseDataSource = mock()
        val interactor = module.providesIrregularsInteractor(network, database)
        assertNotNull(interactor)
    }

    @Test
    fun `Check provided network data source`() {
        val fireStoreClient: FireStoreClient = mock()
        val dataSource = module.providesNetworkDataSource(fireStoreClient)
        assertNotNull(dataSource)
    }

    @Test
    fun `Check provided database data source`() {
        val context: Context = mock()
        val dataSource = module.providesDatabaseDataSource(context)
        assertNotNull(dataSource)
    }
}
