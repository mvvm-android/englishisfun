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

import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import dependencies.TestDependencies
import extensions.implementation

plugins {
    id("commons.android-library")
}

dependencies {
    implementation(Dependencies.PAGING)
    implementation(Dependencies.NAVIGATION_UI)

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.MOCKITO)
    testImplementation(TestDependencies.MOCKK)
    testImplementation(TestDependencies.ASSERTJ)
    testImplementation(TestDependencies.ROBOELECTRIC)
    testImplementation(TestDependencies.ROOM)
    testImplementation(TestDependencies.CORE)
    testImplementation(TestDependencies.ARCH_CORE)
    testImplementation(TestDependencies.RULES)
    testImplementation(TestDependencies.RUNNER)
    testImplementation(TestDependencies.COROUTINES_TEST)
    testImplementation(TestDependencies.FRAGMENT_TEST)
    testImplementation(TestDependencies.EXT)
    testImplementation(TestDependencies.MOCK_WEB_SERVER)

    annotationProcessor(AnnotationProcessorsDependencies.AUTO_SERVICE)
}
