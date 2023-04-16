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
import com.mooltiverse.oss.nyx.configuration.Defaults

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
/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/7.4/userguide/multi_project_builds.html
 * This project uses @Incubating APIs which are subject to change.
 */

pluginManagement {
    val kordampGradlePluginVersion: String by settings
    val mooltiverseNyxPluginVersion: String by settings
    val foojayResolverPluginVersionversion: String by settings
    val palantirPluginVersion: String by settings

    plugins {
//        id("org.kordamp.gradle.project") version kordampGradlePluginVersion
//        id("org.kordamp.gradle.jar") version kordampGradlePluginVersion
//        id("org.kordamp.gradle.minpom") version kordampGradlePluginVersion
        id("com.mooltiverse.oss.nyx") version mooltiverseNyxPluginVersion
        id("org.gradle.toolchains.foojay-resolver-convention") version foojayResolverPluginVersionversion
        id("com.palantir.baseline") version palantirPluginVersion
id("com.palantir.baseline-config") version palantirPluginVersion
        id("org.inferred.processors") version "3.7.0"
    }
}

plugins {
    id("com.mooltiverse.oss.nyx")
   id("org.gradle.toolchains.foojay-resolver-convention")
}

// Not needed as we're using the .nyx.yaml for configuration
//configure<com.mooltiverse.oss.nyx.gradle.NyxExtension> {
//    // a few examples
//    preset.set(Defaults.PRESET)
//   dryRun.set(true)
//  resume.set(false)
//    stateFile.set(".nyx-state.yml")
//    //  verbosity.set("DEBUG")
//}


rootProject.name = "jaxonomy"
include("lib", "utilities", "list", "app","dto","etl")
