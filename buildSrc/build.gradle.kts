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
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

val quarkusPlatformVersion: String by project
val jandexPluginVersion: String by project
val ktlintPluginVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("io.quarkus:gradle-application-plugin:$quarkusPlatformVersion")
    implementation("org.kordamp.gradle:jandex-gradle-plugin:$jandexPluginVersion")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.22.0")
//    implementation("com.diffplug.spotless-changelog:spotless-changelog-plugin-gradle:2.4.0")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:$ktlintPluginVersion")
    implementation("com.javiersc.gradle-plugins:dependency-updates:0.1.0-rc.45")

    compileOnly("org.jetbrains.kotlin:kotlin-reflect:1.9.20") {
        version {
            strictly("1.6.10")
        }
    }
}
// TODO: pull from properties and transliterate to Kotlin-DSL
// val kotlin_version = "1.6.10"
// configurations.all {
//     resolutionStrategy.eachDependency { DependencyResolveDetails details ->
//         def requested = details.requested
//         if (requested.group == 'org.jetbrains.kotlin' && requested.name == 'kotlin-reflect') {
//             details.useVersion kotlin_version
//         }
//     }
// }
