package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals

class EitherTest {
   @Test
   fun fold() {
      val e = Either.Right("hola")

      val result: String = e.fold(
         onLeft = { "numero: $it" },
         onRight = { "texto: $it" }
      )

      assertEquals("texto: hola", result)

   }

   @Test
   fun testValue() {
      val e = Either.Right(10)
      val value = e.value

      assertEquals(10, value)
   }

}