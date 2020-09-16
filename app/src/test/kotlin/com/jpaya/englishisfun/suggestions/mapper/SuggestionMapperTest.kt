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

package com.jpaya.englishisfun.suggestions.mapper

import com.jpaya.englishisfun.suggestions.data.network.model.SuggestionsRequest
import com.jpaya.englishisfun.suggestions.domain.Suggestions
import com.jpaya.englishisfun.suggestions.ui.SuggestionsPresenter
import org.junit.Assert.assertEquals
import org.junit.Test

class SuggestionMapperTest {

    @Test
    fun `Check domain to network works properly`() {
        val domain = Suggestions(
            title = "Title",
            section = "Section",
            description = "Description"
        )

        val expectedResult = SuggestionsRequest(
            title = "Title",
            section = "Section",
            description = "Description"
        )

        assertEquals(expectedResult, domain.toNetwork())
    }

    @Test
    fun `Check ui to domain works properly`() {
        val ui = SuggestionsPresenter.SuggestionsItem(
            title = "Title",
            section = "Section",
            description = "Description"
        )

        val expectedResult = Suggestions(
            title = "Title",
            section = "Section",
            description = "Description"
        )

        assertEquals(expectedResult, ui.toDomain())
    }
}
