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

package dependencies

/**
 * Definition of compose versions.
 */
object Compose {
    const val KOTLIN_COMPILER_EXTENSION_VERSION = "0.1.0-dev14"
    const val KOTLIN_COMPILER_VERSION = "1.3.70-dev-withExperimentalGoogleExtensions-20200424"
}

/**
 * Project libraries, makes it easy to include external binaries or other library modules to build.
 */
object Libraries {
    private object Versions {
        const val APPCOMPAT = "1.2.0"
        const val COIL = "0.13.0"
        const val COMPOSE = "0.1.0-dev14"
        const val CONSTRAINT_LAYOUT = "2.0.1"
        const val CORE_KTX = "1.3.1"
        const val COROUTINES = "1.3.9"
        const val DATASTORE = "1.0.0-alpha01"
        const val FIREBASE_ANALYTICS = "17.5.0"
        const val FIREBASE_AUTH = "19.3.2"
        const val FIREBASE_CRASHLYTICS = "17.1.1"
        const val FIREBASE_FIRESTORE = "21.4.3"
        const val FIREBASE_PERFORMANCE = "19.0.7"
        const val FRAGMENT = "1.2.5"
        const val HILT = "2.28-alpha"
        const val HILT_VIEWMODEL = "1.0.0-alpha01"
        const val KOTLIN = "1.4.10"
        const val LICENSES_DIALOG = "2.1.0"
        const val LIFECYCLE = "2.2.0"
        const val MATERIAL = "1.2.1"
        const val MOSHI = "1.9.3"
        const val NAVIGATION = "2.3.0"
        const val PAGING = "2.1.2"
        const val PLAY_CORE = "1.7.3"
        const val PREFERENCES = "1.1.1"
        const val RAINBOW_CAKE = "1.0.0"
        const val RECYCLER_VIEW = "1.1.0"
        const val RECYCLER_VIEW_SCROLL = "2.0.1"
        const val ROOM = "2.2.5"
        const val SHIMMER = "0.5.0"
        const val SWIPE_REFRESH_LAYOUT = "1.0.0"
        const val TIMBER = "4.7.1"
    }

    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val COIL = "io.coil-kt:coil:${Versions.COIL}"
    const val COMPOSE_ANIMATION = "androidx.ui:ui-animation:${Versions.COMPOSE}"
    const val COMPOSE_CORE = "androidx.ui:ui-core:${Versions.COMPOSE}"
    const val COMPOSE_FOUNDATION = "androidx.ui:ui-foundation:${Versions.COMPOSE}"
    const val COMPOSE_LAYOUT = "androidx.ui:ui-layout:${Versions.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.ui:ui-material:${Versions.COMPOSE}"
    const val COMPOSE_MATERIAL_ICONS = "androidx.ui:ui-material-icons-extended:${Versions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose:compose-runtime:${Versions.COMPOSE}"
    const val COMPOSE_TOOLING = "androidx.ui:ui-tooling:${Versions.COMPOSE}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val DATASTORE = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx:${Versions.FIREBASE_ANALYTICS}"
    const val FIREBASE_AUTH = "com.google.firebase:firebase-auth:${Versions.FIREBASE_AUTH}"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics:${Versions.FIREBASE_CRASHLYTICS}"
    const val FIREBASE_FIRESTORE = "com.google.firebase:firebase-firestore-ktx:${Versions.FIREBASE_FIRESTORE}"
    const val FIREBASE_PERFORMANCE = "com.google.firebase:firebase-perf:${Versions.FIREBASE_PERFORMANCE}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_VIEWMODEL}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN}"
    const val KOTLIN_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val KOTLIN_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val KOTLIN_COROUTINES_PLAY_SERVICES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.COROUTINES}"
    const val LICENSES_DIALOG = "de.psdev.licensesdialog:licensesdialog:${Versions.LICENSES_DIALOG}"
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val MOSHI_KTX = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
    const val PLAY_CORE = "com.google.android.play:core:${Versions.PLAY_CORE}"
    const val PREFERNCES = "androidx.preference:preference-ktx:${Versions.PREFERENCES}"
    const val RAINBOW_CAKE = "co.zsmb:rainbow-cake-core:${Versions.RAINBOW_CAKE}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
    const val RECYCLER_VIEW_SCROLL = "com.simplecityapps:recyclerview-fastscroll:${Versions.RECYCLER_VIEW_SCROLL}"
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    const val SHIMMER = "com.facebook.shimmer:shimmer:${Versions.SHIMMER}"
    const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
}

/**
 * Project annotation processor dependencies, makes it easy to include external binaries or other library
 * modules to build.
 */
object AnnotationProcessorsLibraries {
    private object Versions {
        const val AUTO_SERVICE = "1.0-rc4"
        const val DATABINDING = "3.1.4"
        const val HILT = "2.28-alpha"
        const val HILT_VIEWMODEL = "1.0.0-alpha01"
        const val ROOM = "2.2.5"
    }

    const val AUTO_SERVICE = "com.google.auto.service:auto-service:${Versions.AUTO_SERVICE}"
    const val DATABINDING = "com.android.databinding:compiler:${Versions.DATABINDING}"
    const val HILT = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-compiler:${Versions.HILT_VIEWMODEL}"
    const val ROOM = "androidx.room:room-compiler:${Versions.ROOM}"
}

/**
 * Project debug dependencies, makes it easy to include external binaries or other library modules to build.
 */
object DebugLibraries {
    private object Versions {
        const val DEBUG_DB = "1.0.6"
        const val LEAKCANARY = "2.4"
    }

    private const val DEBUG_DB = "com.amitshekhar.android:debug-db:${Versions.DEBUG_DB}"
    private const val LEAKCANARY = "com.squareup.leakcanary:leakcanary-android:${Versions.LEAKCANARY}"

    /**
     * Method to obtain all the debug dependencies.
     *
     * @return An array with all the debug dependencies.
     */
    fun all() = arrayOf(
        DEBUG_DB,
        LEAKCANARY
    )
}

/**
 * Project test dependencies, makes it easy to include external binaries or other library modules to build.
 */
object TestLibraries {
    private object Versions {
        const val ARCH_CORE = "2.1.0"
        const val ASSERTJ = "3.16.1"
        const val COROUTINES = "1.3.9"
        const val EXT = "1.1.2"
        const val FRAGMENT = "1.2.5"
        const val HAMCREST = "2.2"
        const val JUNIT = "4.13"
        const val MOCKITO = "2.2.0"
        const val MOCKK = "1.10.0"
        const val RAINBOW_CAKE = "1.0.0"
        const val ROBOELECTRIC = "4.4"
        const val ROOM = "2.2.5"
        const val TEST = "1.3.0"
    }

    private const val ARCH_CORE = "androidx.arch.core:core-testing:${Versions.ARCH_CORE}"
    private const val ASSERTJ = "org.assertj:assertj-core:${Versions.ASSERTJ}"
    private const val CORE = "androidx.test:core:${Versions.TEST}"
    private const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
    private const val EXT = "androidx.test.ext:junit:${Versions.EXT}"
    private const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${Versions.FRAGMENT}"
    private const val HAMCREST = "org.hamcrest:hamcrest:${Versions.HAMCREST}"
    private const val JUNIT = "junit:junit:${Versions.JUNIT}"
    private const val MOCKITO = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO}"
    private const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
    private const val RAINBOW_CAKE = "co.zsmb:rainbow-cake-test:${Versions.RAINBOW_CAKE}"
    private const val ROBOELECTRIC = "org.robolectric:robolectric:${Versions.ROBOELECTRIC}"
    private const val ROOM = "androidx.room:room-testing:${Versions.ROOM}"
    private const val RULES = "androidx.test:rules:${Versions.TEST}"
    private const val RUNNER = "androidx.test:runner:${Versions.TEST}"

    /**
     * Method to obtain all the test dependencies.
     *
     * @return An array with all the test dependencies.
     */
    fun all() = arrayOf(
        ARCH_CORE,
        CORE,
        COROUTINES_TEST,
        EXT,
        FRAGMENT_TEST,
        HAMCREST,
        JUNIT,
        MOCKITO,
        MOCKK,
        RAINBOW_CAKE,
        ROBOELECTRIC,
        ROOM,
        RULES,
        RUNNER
    )
}

/**
 * Project Android test dependencies, makes it easy to include external binaries or other library modules to build.
 */
object TestAndroidLibraries {
    private object Versions {
        const val COMPOSE = "0.1.0-dev14"
        const val ESPRESSO = "3.3.0"
        const val EXT = "1.1.2"
        const val FRAGMENT = "1.2.5"
        const val LEAKCANARY = "2.4"
        const val MOCKITO = "2.2.0"
        const val PLAY_CORE = "1.7.3"
        const val TEST = "1.3.0"
    }

    private const val COMPOSE_CORE = "androidx.ui:ui-core:${Versions.COMPOSE}"
    private const val COMPOSE_TEST = "androidx.ui:ui-test:${Versions.COMPOSE}"
    private const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    private const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${Versions.FRAGMENT}"
    private const val JUNIT = "androidx.test.ext:junit:${Versions.EXT}"
    private const val LEAKCANARY = "com.squareup.leakcanary:leakcanary-android-instrumentation:${Versions.LEAKCANARY}"
    private const val MOCKITO = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO}"
    private const val PLAY_CORE = "com.google.android.play:core:${Versions.PLAY_CORE}"
    private const val RULES = "androidx.test:rules:${Versions.TEST}"
    private const val RUNNER = "androidx.test:runner:${Versions.TEST}"

    /**
     * Method to obtain all the Android test dependencies.
     *
     * @return An array with all the Android test dependencies.
     */
    fun all() = arrayOf(
        ESPRESSO,
        FRAGMENT_TEST,
        JUNIT,
        LEAKCANARY,
        MOCKITO,
        RULES,
        RUNNER
    )
}
