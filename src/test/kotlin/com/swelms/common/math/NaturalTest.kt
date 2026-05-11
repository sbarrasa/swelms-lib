package com.swelms.common.math

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

class NaturalTest {

   @Test
   fun create() {
      assertFails { Natural(-1) }
      assertEquals(10, Natural(10).value)
   }


   @Test
   fun compareTo() {
      val a = Natural(1)
      val b = Natural(2)
      assertTrue(b > a)
   }

   @Test
   fun plus() {
      val a = Natural(1)
      val b = Natural(2)
      assertEquals(Natural(3), a + b)
   }

   @Test
   fun minus() {
      val a = Natural(1)
      val b = Natural(2)
      assertEquals(Natural(1), b - a)
   }

   @Test
   fun times() {

      assertEquals(Natural(6), (Natural(2) * Natural(3)))
   }

   @Test
   fun div() {
      assertEquals(Natural(2), Natural(6) / Natural(3))
   }

   @Test
   fun rem() {
      assertEquals(Natural(1), Natural(7) % Natural(3))
   }

   @Test
   fun inc() {
      var a = Natural(1)
      assertEquals(Natural(2), ++a)
   }

   @Test
   fun dec() {
      var a = Natural(2)
      assertEquals(Natural(1), --a)
   }

   @Test
   fun decUnderflowFails() {
      var a = Natural(1)
      assertFails { --a }
   }

   @Test
   fun rangeTo() {
      val range = Natural(1)..Natural(10)
      assertTrue(Natural(2) in range)
   }

   @Test
   fun intRange() {
      val range = (Natural(1)..Natural(10)).toIntRange()
      assertTrue(2 in range)
   }

   @Test
   fun intn(){
      val a = 1.n

      assertTrue { a is Natural}
      assertEquals(Natural(1), a)
   }


}