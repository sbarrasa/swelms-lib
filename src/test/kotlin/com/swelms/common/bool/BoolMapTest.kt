package com.swelms.common.bool

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoolMapTest {
   @Test
   fun constructor(){
      val boolMap = BoolMap(1, -1)
      assertEquals(1, boolMap[true])
      assertEquals(-1, boolMap[false])
   }

   @Test
   fun elementByBoolean() {
      val boolMap = 'T' orElse 'F'
      val value = boolMap[true]
      assertEquals('T', value )
   }

   @Test
   fun differentTypeElements(){
      val boolMap = 1 orElse Exception("ERROR")
      assertTrue { boolMap[true] is Int }
      assertTrue { boolMap[false] is Exception }
      assertEquals(1, boolMap[true])
   }

   @Test
   fun booleans(){
      val boolMap = 'T' orElse 'F'
      val a = 1
      val b = 2
      val value = boolMap {a < b}
      assertEquals('T', value)
   }

   @Test
   fun formPair(){
      val pair = 'T' to 'F'
      val boolMap = pair.toBoolMap()

      assertEquals('T', boolMap[true])
   }


}