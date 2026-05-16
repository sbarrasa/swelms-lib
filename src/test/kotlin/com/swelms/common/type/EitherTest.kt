package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class EitherTest {
   @Test
   fun left() {
      val either = Either.Left("error")

      assertEquals("error", either.value)
   }

   @Test
   fun right() {
      val either = Either.Right(10)

      assertEquals(10, either.value)
   }


   @Test
   fun swap() {
      assertEquals(Either.Right("error"), Either.Left("error").swap())
      assertEquals(Either.Left(10), Either.Right(10).swap())
   }

   @Test
   fun of() {
      val result1 = Either.of<String, Int>("hola")
      val result2 = Either.of<String, Int>(10)

      assertEquals("hola", result1.value)
      assertEquals(10, result2.value)

   }

   @Test
   fun ofRight() {
      val result = Either.of<String, Int>(123)

      assertEquals(Either.Right(123), result)
   }

   @Test
   fun ofInvalidType() {
      assertFailsWith<IllegalStateException> {
         Either.of<String, Int>(true)
      }
   }

   @Test
   fun ofAmbiguousType() {
      val a = Either.of<Number, Int>(10)
      assertTrue { a is Either.Right }
      assertTrue { a.value is Int }
   }



}
