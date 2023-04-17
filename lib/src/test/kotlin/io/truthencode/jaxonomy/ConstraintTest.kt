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
package io.truthencode.jaxonomy

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lang.taxi.annotations.Constraint
import lang.taxi.annotations.DataType
import lang.taxi.annotations.ParameterType
import lang.taxi.generators.java.TaxiGenerator
import java.math.BigDecimal
import java.util.logging.Logger

class ConstraintTest : DescribeSpec({

    val LOGGER = Logger.getLogger("io.truthencode.jaxonomy.ConstraintTest")

    @DataType("vyne.Money")
    data class Money(val amount: BigDecimal, val currency: String)

    @ParameterType
    @DataType("vyne.SomeRequest")
    data class SomeRequest(@Constraint("currency = 'USD'") val amount: Money)

    describe("A Money type") {
        it("should have a default currency of USD") {
            val data = TaxiGenerator().forClasses(Money::class.java, SomeRequest::class.java).generateAsStrings()
            data.size.shouldBe(1)
//            assertTrue(data.size == 1)
            System.out.println("show me someting")
            LOGGER.warning(data[0])
            System.out.println(data[0])
        }
    }
})
