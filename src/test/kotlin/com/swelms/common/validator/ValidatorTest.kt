package com.swelms.common.validator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ValidatorTest {
    val validator = Validator<Int>("Value {1} too small") { it > 10 }

    @Test
    fun validateSuccess() {
        val result = validator.validate(15)
        assertEquals(15, result)
    }

    @Test
    fun validateFailure() {
        val exception = assertFailsWith<ValidatorException> {
            validator.validate(5)
        }
        assertEquals("Value 5 too small", exception.message)
    }
}
