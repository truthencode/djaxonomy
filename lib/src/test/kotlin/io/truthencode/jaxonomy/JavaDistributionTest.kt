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
package io.truthencode.jaxonomy

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlin.test.Test
import kotlin.test.assertTrue

class JavaDistributionTest {
    @Test
    fun someLibraryMethodReturnsTrue() {
        // data from https://api.foojay.io/disco/v2.0/distributions
        val mapper = jacksonObjectMapper()
        this.javaClass.getResourceAsStream("/java-distributions.json").use { inputStream ->
            val results = mapper.readTree(inputStream)
            assertTrue(!results.isEmpty)
            for (rslt in results) {
                System.out.println(rslt.toPrettyString())
                // FIXME: Requires type mapper from WebService -> Distribution object
                // val dists: List<Distribution> = mapper.readValue(rslt.toString())
            }
        }
    }
}
