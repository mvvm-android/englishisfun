package com.jpaya.base.di

import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class UtilsModuleTest {

    private lateinit var module: UtilsModule

    @Before
    fun setUp() {
        module = UtilsModule()
    }

    @Test
    fun verifyProvidedThemeUtils() {
        assertNotNull(module.providesThemeUtils())
    }
}
