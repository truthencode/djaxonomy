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
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.string.shouldContain
import io.truthencode.djaxonomy.GradleKotlinCompat
import it.skrape.core.htmlDocument
import it.skrape.fetcher.*

import it.skrape.selects.DocElement
import it.skrape.selects.and
import it.skrape.selects.html5.*

//import it.skrape.selects.html5.caption


class GradleKotlinResourcesTest : DescribeSpec({
    val compatUrl = "https://docs.gradle.org/8.0/userguide/compatibility.html#kotlin"
    val logger = KotlinLogging.logger {}
    beforeTest {

    }

    afterTest { (testCase, result) ->
    }

    val gradleKotlinCompatHtml = """
         <html lang="en_US">
            <body>
        <table class="tableblock frame-all grid-all stretch">
        <caption class="title">Table 2. Embedded Kotlin version</caption>
        <colgroup>
        <col style="width: 33.3333%;">
        <col style="width: 33.3333%;">
        <col style="width: 33.3334%;">
        </colgroup>
        <tbody>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">Gradle version</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">Embedded Kotlin version</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">Kotlin Language version</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">5.0</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.10</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">5.1</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.11</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">5.2</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.20</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">5.3</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.21</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">5.5</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.31</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">5.6</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.41</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">6.0</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.50</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">6.1</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.61</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">6.3</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.70</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">6.4</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.71</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">6.5</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3.72</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">6.8</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.4.20</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.3</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">7.0</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.4.31</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.4</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">7.2</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.5.21</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.4</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">7.3</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.5.31</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.4</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">7.5</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.6.21</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.4</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">7.6</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.7.10</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.4</p></td>
        </tr>
        <tr>
        <td class="tableblock halign-left valign-top"><p class="tableblock">8.0</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.8.10</p></td>
        <td class="tableblock halign-left valign-top"><p class="tableblock">1.8</p></td>
        </tr>
        </tbody>
        </table>
        </body>
        </html>
    """.trimIndent()

    data class CompatInfo(var compatInfo: List<GradleKotlinCompat> = emptyList())
    describe("Gradle Kotlin Compatibility tables") {
        it("should be read from a table for embedded") {


            htmlDocument(gradleKotlinCompatHtml) {

                table {
                    withClass = "tableblock" and "frame-all"

                    var cap: List<DocElement>? = emptyList()

                    caption {
                        withClass = "title"
                        this.findAll {
                            cap = this
                            this.forEach { e -> e.text shouldContain "Table" }

                        }
                    }
                    cap?.let {
                        logger.warn {
                            "found ${cap?.size} captions"
                        }
                    }
                    findAll("tr").forEach { a ->
                        val data = a.findAll("td")
                        logger.warn("found ${data.size} cells")
                        data.size shouldBeExactly 3
                        Triple(data[0], data[1], data[2])
                    }

                }
//                "#content > div:nth-child(2) > div > table" {
////                            findFirst {
////                                text toBe "i'm a paragraph"
////                            }
////                            findAll {
////                                size toBe 2
////                            }
////                        }
            }
        }
    }

    describe("A working url scrape template") {
        it("should be able to be ignored") {
            val sd = skrape(HttpFetcher) {
                request {
                    url = compatUrl
                }

                extractIt<CompatInfo> { ci ->
//                   val hd = htmlDocument(responseBody,baseUri)
                    this.htmlDocument {
                        "#content > div:nth-child(2) > div > table" {
                            withClass = "tableblock" and "frame-all"

                            var cap: List<DocElement>? = emptyList()

                            caption {
                                withClass = "title"
                                this.findAll {
                                    cap = this
                                    this.forEach { e -> e.text shouldContain "Table" }

                                }
                            }
                            cap?.let {
                                logger.warn {
                                    "found ${cap?.size} captions"
                                }
                            }
                            findAll("tr:nth-child(n+2)").forEach { a ->
                                val data = a.findAll("td")
                                data.size shouldBeExactly 3
                                logger.warn("found ${data.size} cells, adding to existing ${ci.compatInfo.size} values")
                                val gc = GradleKotlinCompat(data[0].text, data[1].text, data[2].text)
                                logger.warn("info -> $gc")
                                ci.compatInfo = ci.compatInfo.plus(gc)
                                logger.warn("new size ${ci.compatInfo.size}")
                            }

                        }
                    }
                }
            }

            sd.compatInfo.size shouldBeExactly 18
            logger.warn("Gradle Kotlin / Embedded Compatibility ${sd.compatInfo}")
        }
    }


//    xdescribe("Gradle Kotlin Compatibility") {
//        it("should be available for embedded") {
//            val extracted = skrape(HttpFetcher) {
//                request {
//                    url = compatUrl
//                }
//
//                response {
//                    status {
//                        code shouldBe 200
//                        message shouldBe "OK"
//                    }
//
//                    contentType shouldBe ContentTypes.TEXT_HTML_UTF8
//
//                    htmlDocument {
//                        table {
//                            withClass = "tableblock" and "frame-all"
//
////                            font-size: 100%;
////                            font-weight: normal;
////                            font-style: normal;
////                            cursor: auto;
////                            tab-size: 4;
////                            color: #02303A;
////                            font-family: "Lato", "Helvetica Neue", Arial, sans-serif;
////                            line-height: 1.5;
////                            -webkit-text-size-adjust: 100%;
////                            direction: ltr;
////                            box-sizing: border-box;
////                            border-spacing: 0;
////                            background: white;
////                            margin-bottom: 1.25em;
////                            max-width: 100%;
////                            border-collapse: separate;
////                            border: 0 solid #dedede;
////                            border-width: 1px;
//                        }
//
////                        "#content > div:nth-child(2) > div > table" {
////                            findFirst {
////                                text toBe "i'm a paragraph"
////                            }
////                            findAll {
////                                size toBe 2
////                            }
////                        }
//                    }
//                }
//            }
//        }
//    }
})