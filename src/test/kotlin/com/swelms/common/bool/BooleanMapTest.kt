package com.swelms.common.bool

import kotlin.test.Test
import kotlin.test.assertEquals

class BooleanMapTest {
   @Test
   fun getTrue() {
       val charBool = BooleanMap('T', 'F')
       assertEquals('T', charBool[true])
   }

   @Test
   fun getFalse() {
       val intBool = BooleanMap(1, 0)
       assertEquals(0, intBool[false])
   }

   @Test
   fun mapTrue() {
       val value = true.map(1,0)
       assertEquals(1, value)
   }

   @Test
   fun mapFalse() {
       val value = false.map(1,0)
       assertEquals(0, value)
   }


}