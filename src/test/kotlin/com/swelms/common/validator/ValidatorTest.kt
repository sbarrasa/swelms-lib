package com.swelms.common.validator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ValidatorTest {
    val validator = Validator(Rule<Int>("Value {1} too small") { it > 10 })

    @Test
    fun success() {
        val result = validator.validate(15)
        assertEquals(15, result)
    }

    @Test
    fun fail() {
        val exception = assertFailsWith<ValidatorException> {
            validator.validate(5)
        }
        assertEquals("Value 5 too small", exception.message)
    }

}
