import org.gradle.accessors.dm.LibrariesForLibs

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
    id("buildlogic.scala-library-profile")
    id("com.zlad.gradle.avrohugger")
}

repositories {

    mavenCentral()
    maven {
        name = "OrbitalHQ"
        url = uri("https://repo.orbitalhq.com/release")
    }
}
val libs = the<LibrariesForLibs>()
val builderScalaVersion: String by project
dependencies {
    /*
    https://github.com/fthomas/refined
    check out refined library for compile time constraints
    unsure how  helpful this will be as most data will need runtime validation (aka wix / zio.validation)
     */
    // Use Scala $scalaMajorVersion in our library project
    if (builderScalaVersion != "3") {
        implementation(libs.savro.s213)
    }

    implementation(libs.taxi.jpa)
    implementation(libs.taxi.avrototaxi)
    // https://mvnrepository.com/artifact/org.apache.avro/avro-tools
    implementation(libs.avro.tools)
    // https://savro.dataedu.ca/

    testCompileOnly(libs.lombok)

    testAnnotationProcessor(libs.lombok)

    testImplementation(platform(libs.junit.junit5.bom))
    testImplementation(libs.guava.jre)
    testImplementation(libs.hamcrest.core)
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly(libs.junit.platform.launcher)
}
//
// tasks.withType<ScalaCompile>().configureEach {
//    scalaCompileOptions.apply {
//
//        when (builderScalaVersion) {
//            "3" -> {
//                logger.warn("Scala 3 detected")
//                additionalParameters?.plusAssign(
//                    listOf(
//                        "-feature",
//                        "-explain",
//                        "-Wsafe-init", // Added per Quarkus - Scala3 extension notes along with semanticdb
//                        "-Xsemanticdb",
//                        "-semanticdb-target",
//                        project.layout.buildDirectory
//                            .get()
//                            .toString(),
//                        "-Yretain-trees", // Needed for Enumeratum
//                        "-rewrite",
// //                        "-new-syntax",
//                        "-source:3.4-migration",
//                        "-Xignore-scala2-macros",
//                        "-new-syntax",
// //                        "explain"
//                    ),
//                )
//            }
//
//            "2" -> {
//                logger.warn("Scala 2 detected")
//                additionalParameters?.plusAssign(
//                    listOf(
//                        "-feature",
//                        "-deprecation",
//                        "-Ywarn-dead-code",
//                        "-Xsource:3-cross",
//                    ),
//                )
//            }
//
//            else -> {
//                logger.error("Scala version $builderScalaVersion not supported")
//            }
//        }
//    }
// }

// OpenApi code / schema generation

// val apiSpec: FileCollection = project.rootProject.layout.files("$rootDir/specs/ddo-fatespinner-oas3-swagger.yaml")
// Location of Avro schema files
val schemaDir: FileCollection = layout.files("src/main/avro")
// Location of generated Scala source files
val generatedScalaSourceDir = project.rootProject.layout.files("../../subprojects/common/ddo-modeling/build/avro-gen")
//
avrohugger {
    this.sourceDirectories {
        this.from(schemaDir)
    }
    // TODO: Copy generated files to 'properly included build directory'.
    // Likely ddo-modeling build directory
    this.destinationDirectory.set(generatedScalaSourceDir.singleFile)
    typeMapping {
        enumType = com.zlad.gradle.avrohugger.AvrohuggerExtension.ScalaCaseObjectEnum
    }
}
