package com.sbarrasa.util

import kotlin.test.Test
import kotlin.test.*

class ValidatorTest {

    @Test
    fun validString(){
        val result = "Hola mundo".isValid {
            this.isNotBlank() and (this.length > 5)
        }

        assertTrue { result }
     }

    @Test
    fun validInt(){
        val result = 10.isValid { this in 1..100 }
        assertTrue { result }

    }
    @Test
    fun notValidInt(){
        val result = 10.isValid { this in 1..5}
        assertFalse { result }

    }

    @Test
    fun validatorWithOutException(){
        val validator = Validator<String> {
            this.length > 5
        }

        val value  = "Hola"
        assertFailsWith<RuntimeException> { validator.validate(value)}
    }

    @Test
    fun validatorWithException(){
        val validator = Validator<String>({IllegalArgumentException(it)}) {
            this.length > 5
        }

        val value  = "Hola"
        assertFailsWith<IllegalArgumentException> { validator.validate(value)}
    }
    @Test
    fun validateWithException(){

        val value  = "Hola"

        assertFailsWith<IllegalArgumentException> {
            value.validate({IllegalArgumentException(it)}) {
                this.length > 5
            }
        }
    }

    @Test
    fun validateWithPersonalizedExceptionandMessage(){

        val value  = "Hola"

        val err = assertFailsWith<IllegalArgumentException> {
            value.validate(
                {IllegalArgumentException(it)},
                { "El valor ${it} es inválido"} ) {
                this.length > 5
            }
        }

        assertEquals("El valor Hola es inválido", err.message)
    }
}