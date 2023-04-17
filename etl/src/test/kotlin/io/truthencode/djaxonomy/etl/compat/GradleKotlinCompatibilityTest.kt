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
package io.truthencode.djaxonomy.etl.compat

import io.github.oshai.KotlinLogging
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldNotBe
import it.skrape.core.htmlDocument
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.extractIt
import it.skrape.fetcher.skrape
import it.skrape.selects.and
import it.skrape.selects.eachText
import it.skrape.selects.html5.a
import it.skrape.selects.html5.div
import it.skrape.selects.html5.p
import it.skrape.selects.html5.span

class GradleKotlinCompatibilityTest : DescribeSpec({

    beforeTest {
    }

    afterTest { (testCase, result) ->
    }

    val logger = KotlinLogging.logger {}
    data class MyExtractedData(
            var httpMessage: String = "",
            var userName: String = "",
            var repositoryNames: List<String> = emptyList(),
            var theThirdRepositoriesName: String = "",
            var firstThreeHrefs: List<String> = emptyList(),
            var overviewLink: String = "",
            var firstThreeImageSources: List<String> = emptyList(),
            var title: String = "",
            var starsCount: String = ""
    )

    describe("Gradle Kotlin Compatibility") {
        it("should be available for embedded") {
            val extracted = skrape(HttpFetcher) { // 1️⃣
                request {
                    url = "https://github.com/skrapeit"
                }

                extractIt<MyExtractedData> { it ->
                    it.httpMessage = status { message } // 2️⃣
                    htmlDocument { // 3️⃣
                        relaxed = true // 4️⃣

                        it.userName = ".h-card .p-nickname" { findFirst { text } } // 5️⃣
                        val repositories = span(".repo") { findAll { this } } // 6️⃣
                        println("hello world") // 7️⃣
                        it.repositoryNames = repositories.filter { it.text.contains("skrape") }.eachText // 8️⃣
                        it.theThirdRepositoriesName = span(".repo") {
                            2 { text } // 9️⃣
                        }
                        it.firstThreeImageSources = findAll { eachImage.map { image -> image.value } }.take(3) // 1️⃣0️⃣
                        it.firstThreeHrefs = findAll { eachHref }.take(3) // 1️⃣1️⃣
                        it.overviewLink = findAll { eachLink["Overview"] ?: "not found" } // 1️⃣2️⃣
                        it.title = titleText // 1️⃣3️⃣

                        // *️⃣
                        it.starsCount = div { // 1️⃣5️⃣
                            withClass = "pinned-item-list-item"
                            findFirst {
                                p { // 1️⃣6️⃣
                                    findSecond {
                                        a {
                                            // 1️⃣7️⃣
                                            withClass = "pinned-item-meta" and "muted-link" // 1️⃣8️⃣
                                            withAttribute = "href" to "/skrapeit/skrape.it/stargazers" // 1️⃣9️⃣

                                            findFirst {
                                                ownText
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            extracted.firstThreeHrefs shouldNotBe emptyList<String>()
            logger.warn{ "extracted -> $extracted"}

        }
    }
})
