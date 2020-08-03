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

package com.jpaya.englishisfun.di

import android.content.Context
import androidx.room.Room
import com.jpaya.englishisfun.EnglishIsFunApp
import com.jpaya.englishisfun.irregulars.data.db.IrregularsDao
import com.jpaya.englishisfun.database.EnglishIsFunDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

/**
 * Class that provides the application-level dependencies to the hilt dependency graph [ApplicationComponent].
 * All dependencies provided by this class will be considered as application-level properties.
 */
@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    /**
     * Create a provider method binding for [Context].
     *
     * @param application Application instance.
     * @return Instance of context.
     */
    @Provides
    fun provideContext(application: EnglishIsFunApp): Context = application.applicationContext

    /**
     * Create a provider method binding for [CoroutineScope].
     *
     * @return Instance of coroutine scope.
     */
    @Provides
    fun providesCoroutinesScope(): CoroutineScope = MainScope()

    /**
     * Create a provider method binding for [EnglishIsFunDatabase].
     *
     * @param context Application context.
     * @return Instance of irregulars database.
     */
    @Provides
    fun providesIrregularsDatabase(@ApplicationContext context: Context): EnglishIsFunDatabase =
        Room.databaseBuilder(context, EnglishIsFunDatabase::class.java, EnglishIsFunDatabase.DATABASE_NAME).build()

    /**
     * Create a provider method binding for [EnglishIsFunDatabase].
     *
     * @param database Database instance.
     * @return Instance of irregulars dao.
     */
    @Provides
    fun providesIrregularsDao(database: EnglishIsFunDatabase): IrregularsDao = database.irregulars()
}
