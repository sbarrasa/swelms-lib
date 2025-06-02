package com.sbarrasa.util

import kotlin.test.*

class ValidatorTest {

   @Test
   fun validString() {
      val result = "Hola mundo".isValid {
         this.isNotBlank() and (this.length > 5)
      }
      assertTrue { result }
   }

   @Test
   fun validInt() {
      val result = 10.isValid { this in 1..100 }
      assertTrue { result }

   }

   @Test
   fun notValidInt() {
      val result = 10.isValid { this in 1..5 }
      assertFalse { result }

   }

   @Test
   fun validatorWithOutException() {
      val validator = Validator<String> {
         this.length > 5
      }

      val value = "Hola"
      assertFailsWith<RuntimeException> { validator.validate(value) }
   }

   @Test
   fun validatorWithException() {
      val validator = Validator<String>({ IllegalArgumentException(it) }) {
         this.length > 5
      }

      val value = "Hola"
      assertFailsWith<IllegalArgumentException> { validator.validate(value) }
   }


   @Test
   fun validatorWithExceptionandMessage() {

      val validator = Validator<String>(
         exception = { IllegalArgumentException(it) },
         message = { "El valor ${it} no es válido" }) {
         this.length > 5
      }

      val err = assertFailsWith<IllegalArgumentException> {
         validator.validate("hola")
      }

      assertEquals("El valor hola no es válido", err.message)
   }
}