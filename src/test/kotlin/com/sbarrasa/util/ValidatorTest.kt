package com.sbarrasa.util

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class ValidatorTest {
    @Test
    fun validateString(){
        val result = "Hola mundo".validate(
            {this.isNotBlank()},
            {this.length > 5 }
        )

        assertTrue { result }
     }

    @Test
    fun validateInt(){
        val result = 10.validate(
            {  this > 1 },
            { this -5 == 5}
        )
        assertTrue { result }

    }

    @Test
    fun validateWithException(){
        val validator = Validator<String>(
            { this.length > 5},
            onFailure = {IllegalArgumentException(it)}
        )

        val value  = "Hola"
        assertFailsWith<IllegalArgumentException> { validator.validate(value)}
    }

}