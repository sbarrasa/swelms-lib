package com.swelms.common.type

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoolMapTest {
   @Test
   fun constructor() {
      val boolMap = BoolMap(1, -1)
      assertEquals(1, boolMap[true])
      assertEquals(-1, boolMap[false])
   }

   @Test
   fun elementByBoolean() {
      val boolMap = 'T' orElse 'F'
      val value = boolMap[true]
      assertEquals('T', value)
   }

   @Test
   fun differentTypeElements() {
      val boolMap = 1 orElse "false"
      assertTrue { boolMap[true] is Int }
      assertTrue { boolMap[false] is String }
      assertEquals(1, boolMap[true])
   }

   @Test
   fun booleans() {
      val boolMap = 'T' orElse 'F'
      val a = 1
      val b = 2
      val value = boolMap { a < b }
      assertEquals('T', value)
   }

   @Test
   fun formPair() {
      val pair = 'T' to 'F'
      val boolMap = pair.toBoolMap()

      assertEquals('T', boolMap[true])
   }


   @Test
   fun fromNullable() {
      val boolMap = BoolMap(1, null)
      assertEquals(1, boolMap[true])
      assertEquals(null, boolMap[false])
      assertTrue { boolMap[false] is Nothing? }
   }

   object Binary : BoolMap<Byte>(1, 0)

   @Test
   fun fromObject() {
      assertEquals(1, Binary[true])
      assertEquals(0, Binary[false])
   }

}