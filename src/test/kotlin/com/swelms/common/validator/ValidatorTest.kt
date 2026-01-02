package com.swelms.common.validator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ValidatorTest {
    @Test
    fun validateSuccess() {
        val validator = Validator<Int>("Value too small") { it > 10 }
        val result = validator.validate(15)
        assertEquals(15, result)
    }

    @Test
    fun validateFailure() {
        val validator = Validator<Int>("Value too small") { it > 10 }
        val exception = assertFailsWith<ValidatorException> {
            validator.validate(5)
        }
        assertEquals("Value too small", exception.message)
    }
}
