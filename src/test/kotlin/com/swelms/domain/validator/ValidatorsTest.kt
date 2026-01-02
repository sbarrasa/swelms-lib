package com.swelms.domain.validator

import com.swelms.common.validator.ValidatorException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ValidatorsTest {

    @Test
    fun digitsValidator() {
        val validator = DigitsValidator()
        assertEquals("123", validator.validate("123"))
        assertFailsWith<ValidatorException> { validator.validate("12a3") }
    }

    @Test
    fun lengthValidator() {
        val validator = LengthValidator(size = 3)
        assertEquals("abc", validator.validate("abc"))
        assertFailsWith<ValidatorException> { validator.validate("ab") }
        assertFailsWith<ValidatorException> { validator.validate("abcd") }
    }

    @Test
    fun notNullValidator() {
        val validator = NotNullValidator()
        assertEquals("hello", validator.validate("hello"))
        assertFailsWith<ValidatorException> { validator.validate(null) }
    }

    @Test
    fun checkDigitValidator() {
        val validator = object : CheckDigitValidator("Invalid check digit") {
            override fun compute(digits: List<Int>): Int = digits.sum() % 10
        }
        
        // Sum of 1, 2, 3 is 6. 6 % 10 = 6.
        assertEquals("1236", validator.validate("1236"))
        assertFailsWith<ValidatorException> { validator.validate("1235") }
    }
}
