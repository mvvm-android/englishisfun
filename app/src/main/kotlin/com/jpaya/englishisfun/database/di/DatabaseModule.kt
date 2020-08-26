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

package com.jpaya.englishisfun.database.di

import android.content.Context
import com.jpaya.englishisfun.abbreviations.data.db.AbbreviationsDao
import com.jpaya.englishisfun.conditionals.data.db.ConditionalsDao
import com.jpaya.englishisfun.database.EnglishIsFunDatabase
import com.jpaya.englishisfun.idioms.data.db.IdiomsDao
import com.jpaya.englishisfun.irregulars.data.db.IrregularsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Class that provides the database-level dependencies to the hilt dependency graph [ApplicationComponent].
 * All dependencies provided by this class will be considered as application-level properties.
 */
@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    /**
     * Create a provider method binding for [EnglishIsFunDatabase].
     *
     * @param context Application context.
     * @return Instance of the database.
     */
    @Provides
    fun providesDatabase(@ApplicationContext context: Context) = EnglishIsFunDatabase.create(context)

    /**
     * Create a provider method binding for [IrregularsDao].
     *
     * @param database Database instance.
     * @return Instance of irregulars dao.
     */
    @Provides
    fun providesIrregularsDao(database: EnglishIsFunDatabase): IrregularsDao = database.irregulars()

    /**
     * Create a provider method binding for [AbbreviationsDao].
     *
     * @param database Database instance.
     * @return Instance of abbreviations dao.
     */
    @Provides
    fun providesAbbreviationsDao(database: EnglishIsFunDatabase): AbbreviationsDao = database.abbreviations()

    /**
     * Create a provider method binding for [IdiomsDao].
     *
     * @param database Database instance.
     * @return Instance of idioms dao.
     */
    @Provides
    fun providesIdiomsDao(database: EnglishIsFunDatabase): IdiomsDao = database.idioms()

    /**
     * Create a provider method binding for [ConditionalsDao].
     *
     * @param database Database instance.
     * @return Instance of conditionals dao.
     */
    @Provides
    fun providesConditionalsDao(database: EnglishIsFunDatabase): ConditionalsDao = database.conditionals()
}
