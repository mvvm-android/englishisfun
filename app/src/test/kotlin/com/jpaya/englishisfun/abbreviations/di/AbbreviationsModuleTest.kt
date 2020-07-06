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

class AbbreviationsModuleTest {

//    @MockK
//    lateinit var fragment: AbbreviationsListFragment
//    private lateinit var module: AbbreviationsModule
//
//    @Before
//    fun setUp() {
//        MockKAnnotations.init(this)
//        module = AbbreviationsModule()
//    }
//
//    @Test
//    fun initializeCharactersListModule_ShouldSetUpCorrectly() {
//        assertEquals(fragment, module.fragment)
//    }
//
//    @Test
//    fun verifyProvidedAbbreviationsListViewModel() {
//        mockkStatic("com.jpaya.base.ui.extensions.FragmentExtensionsKt")
//
//        every {
//            fragment.viewModel(any(), any<() -> ViewModel>())
//        } returns mockk<AbbreviationsListViewModel>()
//
//        val factoryCaptor = slot<() -> AbbreviationsListViewModel>()
//        val dataFactory = mockk<AbbreviationsPageDataSourceFactory>(relaxed = true)
//        module.providesAbbreviationsListViewModel(dataFactory)
//
//        verify { fragment.viewModel(factory = capture(factoryCaptor)) }
//
//        assertEquals(dataFactory, factoryCaptor.captured().dataSourceFactory)
//    }
//
//    @Test
//    fun verifyProvidedCharactersPageDataSource() {
//        val fireStoreClient = mockk<FireStoreClient>(relaxed = true)
//        val dataSource = module.providesAbbreviationsPageDataSource(fireStoreClient = fireStoreClient)
//        assertEquals(fireStoreClient, dataSource.fireStoreClient)
//    }
//
//    @Test
//    fun verifyProvidedAbbreviationsListAdapter() {
//        val viewModel = mockk<AbbreviationsListViewModel>(relaxed = true)
//        val adapter = module.providesAbbreviationsListAdapter(viewModel)
//        assertEquals(viewModel, adapter.viewModel)
//    }
}
