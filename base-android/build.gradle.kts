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

import dependencies.AnnotationProcessorsLibraries
import dependencies.Libraries
import extensions.implementation
import extensions.kapt

plugins {
    id("commons.android-library")
}

junitJacoco {
    excludes = listOf("**/extensions/NavigationExtensions*.*")
}

allOpen {
    // allows mocking for classes w/o directly opening them for release builds
    annotation("com.jpaya.core.annotations.OpenClass")
}

dependencies {
    implementation(
        arrayOf(
            Libraries.COIL,
            Libraries.CONSTRAINT_LAYOUT,
            Libraries.CORE_KTX,
            Libraries.FIREBASE_FIRESTORE,
            Libraries.FIREBASE_AUTH,
            Libraries.FRAGMENT_KTX,
            Libraries.HILT,
            Libraries.LIFECYCLE_EXTENSIONS,
            Libraries.LIFECYCLE_VIEWMODEL,
            Libraries.LOGGING,
            Libraries.MOSHI,
            Libraries.MOSHI_KTX,
            Libraries.NAVIGATION_FRAGMENT,
            Libraries.NAVIGATION_UI,
            Libraries.PAGING,
            Libraries.RECYCLER_VIEW,
            Libraries.RETROFIT,
            Libraries.RETROFIT_CONVERTER,
            Libraries.ROOM,
            Libraries.ROOM_KTX
        )
    )
    kapt(
        arrayOf(
            AnnotationProcessorsLibraries.DATABINDING,
            AnnotationProcessorsLibraries.HILT,
            AnnotationProcessorsLibraries.ROOM
        )
    )
}
