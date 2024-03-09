/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2022 Andre White.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("djaxonomy.kotlin-library-conventions")
}

java.sourceSets["main"].java {
    srcDir("src/generated/kotlin")
}
val taxiVersion: String by project

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:30.1.1-jre")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")
    implementation("org.taxilang:taxi-annotations:$taxiVersion")

    testImplementation(enforcedPlatform("com.fasterxml.jackson:jackson-bom:2.16.2"))
    testImplementation("com.fasterxml.jackson.module:jackson-module-parameter-names")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use Kotlin Test test framework
            useKotlinTest()
        }
    }
}
