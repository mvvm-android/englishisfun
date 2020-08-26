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

package com.jpaya.englishisfun.suggestions.ui

import com.jpaya.englishisfun.suggestions.domain.Suggestions
import com.jpaya.englishisfun.suggestions.domain.SuggestionsInteractor
import com.jpaya.englishisfun.suggestions.ui.SuggestionsPresenter.SuggestionsItem
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SuggestionsPresenterTest {

    companion object {
        private val MOCK_UI_ITEM = SuggestionsItem(
            title = "Title",
            section = "Section",
            description = "Description"
        )
        private val MOCK_DOMAIN_ITEM = Suggestions(
            title = "Title",
            section = "Section",
            description = "Description"
        )
    }

    private lateinit var interactor: SuggestionsInteractor
    private lateinit var presenter: SuggestionsPresenter

    @Before
    fun setUp() {
        interactor = mock()
        presenter = SuggestionsPresenter(interactor)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check sendSuggestion works properly`() = runBlocking {
        presenter.sendSuggestion(MOCK_UI_ITEM)
        verify(interactor).sendSuggestion(MOCK_DOMAIN_ITEM)
    }
}
