package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

class EitherTest {
   @Test
   fun left() {
      val either = Either.Left("error")

      assertEquals("error", either.value)
      assertEquals("error", either.left())
      assertNull(either.right())
   }

   @Test
   fun right() {
      val either = Either.Right(10)

      assertEquals(10, either.value)
      assertNull(either.left())
      assertEquals(10, either.right())
   }

   @Test
   fun foldLeft() {
      val value = Either.Left("error").fold(
         ifLeft = { "left: $it" },
         ifRight = { "right: $it" }
      )

      assertEquals("left: error", value)
   }

   @Test
   fun foldRight() {
      val value = Either.Right(10).fold(
         ifLeft = { "left: $it" },
         ifRight = { "right: $it" }
      )

      assertEquals("right: 10", value)
   }

   @Test
   fun mapRight() {
      val either = Either.Right(10).map { it * 2 }

      assertEquals(Either.Right(20), either)
   }

   @Test
   fun mapKeepsLeft() {
      val either = Either.Left("error").map { it: Int -> it * 2 }

      assertEquals(Either.Left("error"), either)
   }

   @Test
   fun mapLeft() {
      val either = Either.Left("error").mapLeft { it.uppercase() }

      assertEquals(Either.Left("ERROR"), either)
   }

   @Test
   fun bimap() {
      val left = Either.Left("error").bimap(String::uppercase) { it: Int -> it * 2 }
      val right = Either.Right(10).bimap(String::uppercase) { it * 2 }

      assertEquals(Either.Left("ERROR"), left)
      assertEquals(Either.Right(20), right)
   }

   @Test
   fun swap() {
      assertEquals(Either.Right("error"), Either.Left("error").swap())
      assertEquals(Either.Left(10), Either.Right(10).swap())
   }

   class EitherTest {

      @Test
      fun ofLeft() {
         val result = Either.of<String, Int>("hola")

         assertEquals(Either.Left("hola"), result)
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
   }

}
