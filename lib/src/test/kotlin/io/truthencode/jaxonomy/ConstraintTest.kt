package io.truthencode.jaxonomy

import kotlin.test.Test
import java.math.BigDecimal
import lang.taxi.annotations.ParameterType
import lang.taxi.annotations.DataType
import lang.taxi.annotations.Constraint
import lang.taxi.generators.java.TaxiGenerator
import java.util.logging.Logger
import kotlin.test.assertTrue

class ConstraintTest {
    
    val LOGGER = Logger.getLogger("io.truthencode.jaxonomy.ConstraintTest")
    @DataType("vyne.Money") data class Money(val amount: BigDecimal, val currency: String)

    @ParameterType
    @DataType("vyne.SomeRequest")
    data class SomeRequest(@Constraint("currency = 'USD'") val amount: Money)

    @Test fun genConstraint() {
       val data = TaxiGenerator().forClasses(Money::class.java, SomeRequest::class.java).generateAsStrings()
       assertTrue(data.size == 1)
       System.out.println("show me someting")
       LOGGER.warning(data[0])
       System.out.println(data[0])
    }
}
