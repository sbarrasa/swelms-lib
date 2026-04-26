package com.swelms.common.bool

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoolMapTest {
   @Test
   fun constructor(){
      val values = BoolMap(1, -1)
      assertEquals(1, values[true])
      assertEquals(-1, values[false])
   }

   @Test
   fun elementByBoolean() {
      val values = 'T' or 'F'
      val value = values[true]
      assertEquals('T', value )
   }

   @Test
   fun differentTypeElements(){
      val values = 1 or Exception("ERROR")
      assertTrue { values[true] is Int }
      assertTrue { values[false] is Exception }
      assertEquals(1, values[true])
   }



}