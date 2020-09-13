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

package com.jpaya.englishisfun.data.database.di

import com.jpaya.englishisfun.abbreviations.data.db.AbbreviationsDao
import com.jpaya.englishisfun.conditionals.data.db.ConditionalsDao
import com.jpaya.englishisfun.data.database.EnglishIsFunDatabase
import com.jpaya.englishisfun.idioms.data.db.IdiomsDao
import com.jpaya.englishisfun.irregulars.data.db.IrregularsDao
import com.jpaya.englishisfun.phrasals.data.db.PhrasalsDao
import com.jpaya.englishisfun.statives.data.db.StativesDao
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DatabaseModuleTest {

    private lateinit var databaseModule: DatabaseModule

    @Before
    fun setUp() {
        databaseModule = DatabaseModule()
    }

    @Test
    fun verifyProvidedDatabase() = assertNotNull(databaseModule.providesDatabase(mock()))

    @Test
    fun verifyProvidedIrregularsDao() {
        val database: EnglishIsFunDatabase = mock()
        val dao: IrregularsDao = mock()
        doReturn(dao).whenever(database).irregulars()

        assertNotNull(databaseModule.providesIrregularsDao(database))
        assertEquals(dao, databaseModule.providesIrregularsDao(database))
    }

    @Test
    fun verifyProvidedAbbreviationsDao() {
        val database: EnglishIsFunDatabase = mock()
        val dao: AbbreviationsDao = mock()
        doReturn(dao).whenever(database).abbreviations()

        assertNotNull(databaseModule.providesAbbreviationsDao(database))
        assertEquals(dao, databaseModule.providesAbbreviationsDao(database))
    }

    @Test
    fun verifyProvidedIdiomsDao() {
        val database: EnglishIsFunDatabase = mock()
        val dao: IdiomsDao = mock()
        doReturn(dao).whenever(database).idioms()

        assertNotNull(databaseModule.providesIdiomsDao(database))
        assertEquals(dao, databaseModule.providesIdiomsDao(database))
    }

    @Test
    fun verifyProvidedConditionalsDao() {
        val database: EnglishIsFunDatabase = mock()
        val dao: ConditionalsDao = mock()
        doReturn(dao).whenever(database).conditionals()

        assertNotNull(databaseModule.providesConditionalsDao(database))
        assertEquals(dao, databaseModule.providesConditionalsDao(database))
    }

    @Test
    fun verifyProvidedStativesDao() {
        val database: EnglishIsFunDatabase = mock()
        val dao: StativesDao = mock()
        doReturn(dao).whenever(database).stative()

        assertNotNull(databaseModule.providesStativeDao(database))
        assertEquals(dao, databaseModule.providesStativeDao(database))
    }

    @Test
    fun verifyProvidedPhrasalsDao() {
        val database: EnglishIsFunDatabase = mock()
        val dao: PhrasalsDao = mock()
        doReturn(dao).whenever(database).phrasals()

        assertNotNull(databaseModule.providesPhrasalsDao(database))
        assertEquals(dao, databaseModule.providesPhrasalsDao(database))
    }
}
