/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2021 Andre White.
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
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
  google()
  mavenCentral()
  maven("https://jitpack.io")
  maven {
    url = uri("https://repo.orbitalhq.com/release")
  }
}

val kotlinVersion: String by project
val quarkusPlatformVersion: String by project
val jandexPluginVersion: String by project
val defaultJavaToolChainVersion: String? by project
val kasechangeVersion: String by project

dependencies {
  implementation(libs.quarkus.gradle.plugin)
  implementation(libs.kotlin.gradle.plugin)
  implementation(libs.kotlin.allopen.plugin)
  implementation(libs.scalafix.plugin)
  implementation(libs.nullaway.plugin)
  implementation(libs.errorprone.plugin)
  implementation(libs.sonar.sonarqube.plugin)

  // enable gradle catalog for included convention plugins
  implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
  // tool languages
  // node
  implementation(libs.node.gradle.plugin)
  implementation(libs.avrohugger.plugin)
  // code quality
  implementation(libs.spotless.plugin)
  implementation(libs.version.catalog.plugin)

  // CI build support
  // TODO: Remove ci plugin and use manual script
  implementation(libs.ci.detect.plugin)

  // scala
  implementation(libs.scalac.scoverage.plugin)

  // bloop This may need to be more dynamic for scala3?
  implementation(libs.gradle.bloop.plugin.s213)

// used for Quarkus Components when not using Quarkus Plugin
  implementation(libs.kordamp.jandex.plugin)

  // Database
  implementation(CashApp.sqlDelight.gradlePlugin)

  // String utils
  // camel / snake etc.
  // universal dependency for Gradle 5.3 and above
  // in case of multiplatform project, just specify the dependency for commonMain/commonTest source set
  implementation(libs.pearx.kasechange)

}

kotlin {
  jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(
      JavaLanguageVersion.of(
        defaultJavaToolChainVersion ?: "21",
      ),
    ) // "8"
    // GraalvmToolchain support doesn't work for CI systems.
    // Circle CI requires custom image since deprecating cicrleci/graal in favor of cimg/openjdk
    // (this as JavaToolchainSpec).vendor.set(JvmVendorSpec.GRAAL_VM)
  }
}
