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

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.string.shouldContain
import it.skrape.core.htmlDocument
import it.skrape.fetcher.BrowserFetcher

import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.response
import it.skrape.fetcher.skrape
import it.skrape.matchers.toBe
import it.skrape.matchers.toBePresent
import it.skrape.matchers.toBePresentExactlyTwice
import it.skrape.selects.and
import it.skrape.selects.html5.caption

//import it.skrape.selects.html5.caption
import it.skrape.selects.html5.div
import it.skrape.selects.html5.span
import it.skrape.selects.html5.table

class GradleKotlinResources : DescribeSpec({
    val compatUrl = "https://docs.gradle.org/8.0/userguide/compatibility.html#kotlin"
    beforeTest {

    }

    afterTest { (testCase, result) ->
    }

    val gradleKotlinCompatHtml = """
         <html>
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

    describe("Gradle Kotlin Compatibility tables") {
        it("should be read from a table for embedded") {


            htmlDocument(gradleKotlinCompatHtml) {
                table {
                    withClass = "tableblock" and "frame-all"

//                            font-size: 100%;
//                            font-weight: normal;
//                            font-style: normal;
//                            cursor: auto;
//                            tab-size: 4;
//                            color: #02303A;
//                            font-family: "Lato", "Helvetica Neue", Arial, sans-serif;
//                            line-height: 1.5;
//                            -webkit-text-size-adjust: 100%;
//                            direction: ltr;
//                            box-sizing: border-box;
//                            border-spacing: 0;
//                            background: white;
//                            margin-bottom: 1.25em;
//                            max-width: 100%;
//                            border-collapse: separate;
//                            border: 0 solid #dedede;
//                            border-width: 1px;
                    var cap: String?
                    caption {
                        withClass = "title"
                        this.findFirst {
                            cap = text
                            text shouldContain "Table"
                        }
                    }
//                        "#content > div:nth-child(2) > div > table" {
//                            findFirst {
//                                text toBe "i'm a paragraph"
//                            }
//                            findAll {
//                                size toBe 2
//                            }
//                        }
                }
            }
        }
    }

    xdescribe("A working url scrape template") {
        it("should be able to be ignored") {
            skrape(BrowserFetcher) {
                request {
                    url = "http://localhost:8080/example"
                }
                response {
//                   val hd = htmlDocument(responseBody,baseUri)
                    this.htmlDocument {
                        // all official html and html5 elements are supported by the DSL
                        div {
                            withClass = "foo" and "bar" and "fizz" and "buzz"

                            findFirst {
                                text toBe "div with class foo"

                                // it's possible to search for elements from former search results
                                // e.g. search all matching span elements within the above div with class foo etc...
                                span {
                                    findAll {
                                        // do something
                                    }
                                }
                            }

                            findAll {
                                toBePresentExactlyTwice
                            }
                        }
                        // can handle custom tags as well
                        "a-custom-tag" {
                            findFirst {
                                toBePresent
                                text toBe "i'm a custom html5 tag"
                                text
                            }
                        }
                        // can handle custom tags written in css selctor query syntax
                        "div.foo.bar.fizz.buzz" {
                            findFirst {
                                text toBe "div with class foo"
                            }
                        }

                        // can handle custom tags and add selector specificas via DSL
                        "div.foo" {

                            withClass = "bar" and "fizz" and "buzz"

                            findFirst {
                                text toBe "div with class foo"
                            }
                        }
                    }
                }
            }
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