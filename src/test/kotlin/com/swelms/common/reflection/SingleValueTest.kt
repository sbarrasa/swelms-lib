package com.swelms.common.reflection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

@JvmInline
value class MyValue(val text: String)

data class SingleProp(val number: Int)
data class MultiProp(val a: Int, val b: String)

object SinglePropObject {val number: Int = 1}

class SingleValueTests {

   @Test
   fun singleValue_returnsValue() {
      val v = MyValue("hello")
      assertEquals("hello", v.singleValue)
   }

   @Test
   fun isSingleValue_true() {
      val s = SingleProp(42)
      assertTrue(s.isSingleValue)
   }

   @Test
   fun isSingleValue_false() {
      val m = MultiProp(1, "x")
      assertFalse(m.isSingleValue)
   }

   @Test
   fun asSingleValueSelf() {
      val v = SingleProp(1)
      val m = MultiProp(1, "y")
      assertEquals(1, v.asSingleValue)
      assertEquals(m, m.asSingleValue)
   }

}
