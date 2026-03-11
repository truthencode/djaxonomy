/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2022-2023 Andre White.
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

import nl.littlerobots.vcu.plugin.versionCatalogUpdate

plugins {
    id("code-quality")
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

if (project == project.rootProject) {
    project.logger.info("Applying version catalog plugin to root project")
    apply(plugin = "nl.littlerobots.version-catalog-update")
    versionCatalogUpdate {
        // https://github.com/littlerobots/version-catalog-update-plugin?tab=readme-ov-file#configuration
        // sort the catalog by key (default is true)
        sortByKey = true
        // Referenced that are pinned are not automatically updated.
        // They are also not automatically kept however (use keep for that).
        pin {
            // pins all libraries and plugins using the given versions
            versions = listOf("scala3-version", "scala2-version")

            // pins specific libraries that are in the version catalog
            // libraries

            // pins specific plugins that are in the version catalog
            // plugins

            // pins all libraries (not plugins) for the given groups
            groups = listOf("org.scala-lang", "org.taxilang")
        }
        keep {
            // keep has the same options as pin to keep specific entries
            // note that for versions it will ONLY keep the specified version, not all
            // entries that reference it.
            versions = listOf("kotlin", "scala3-version", "scala2-version")
            // keep versions without any library or plugin reference
//      keepUnusedVersions = true
        }
    }
}
