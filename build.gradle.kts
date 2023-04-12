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
plugins {
    id("org.kordamp.gradle.project")
//    id("com.mooltiverse.oss.nyx")
}
// general project information
val projectName = project.name
val gitHubAccountName = "truthencode"
val gitHubBaseSite = "https://github.com/$gitHubAccountName/${project.name}"
val siteIssueTracker = "$gitHubBaseSite/issues"
val gitExtension = "${project.name}.git"
val siteScm = "$gitHubBaseSite/$gitExtension"
val JvmMajorTarget: String by project

group = "io.truthencode"

// val releaseActive: Boolean? = rootProject.findProperty("release") as Boolean?

val project_description: String by project

config {
//    release = if (releaseActive != null) releaseActive!! else false
    info {
        name = "DJAXonomy"
        vendor = "TruthEncode"
        description = project_description
        inceptionYear = "2022"
        tags = listOf("taxonomy", "dependency")
//        version = VersionInfo().version

        links {
            website = gitHubBaseSite
            issueTracker = siteIssueTracker
            scm = siteScm
        }

        scm {
            url = gitHubBaseSite
            developerConnection = "scm:git:git@github.com:$gitHubAccountName/$gitExtension"
            connection = "scm:git:git://github.com/github.com/$gitHubAccountName/$gitExtension"
        }

        organization {
            name = "TruthEncode"
            url = "https://github.com/truthencode"
        }

        people {
            person {
                id = "adarro"
                name = "Andre White"
                roles = listOf("developer", "owner")
            }
        }
    }

    licensing {

        licenses {
            license {
                id = "Apache-2.0" // org.kordamp.gradle.plugin.base.model.LicenseId.APACHE_2_0
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
    }
    buildInfo {
        enabled = true
    }
}


subprojects {
    version = rootProject.version
}
