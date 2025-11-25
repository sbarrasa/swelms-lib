package com.swelms.common.reflection

import kotlin.test.Test
import kotlin.test.assertEquals

@JvmInline
value class ValueText(val text: String)

data class DataA(val a: Int?, val b: String?, val c: ValueText?)
data class DataB(var a: Int?, var b: String?, var c: ValueText?)

class CopyTest {

   @Test
   fun copy_sameClass_ignoreNulls() {
      val src = DataB(1, "x", ValueText("v"))
      val tgt = DataB(null, "a", null)
      src.copyTo(tgt)
      assertEquals(1, tgt.a)
      assertEquals("x", tgt.b)
      assertEquals("v", tgt.c?.text)
   }

   @Test
   fun copy_sameClass_withNulls() {
      val src = DataB(null, "y", null)
      val tgt = DataB(10, "z", ValueText("v2"))
      src.copyTo(tgt)
      assertEquals(10, tgt.a)
      assertEquals("y", tgt.b)
      assertEquals("v2", tgt.c?.text)
   }

   @Test
   fun copy_differentClass_sameProps() {
      val src = DataA(5, "x", ValueText("vv"))
      val tgt = DataB(null, null, null)
      src.copyTo(tgt)
      assertEquals(5, tgt.a)
      assertEquals("x", tgt.b)
      assertEquals("vv", tgt.c?.text)
   }

   @Test
   fun copy_singleValueWithNulls_ignoreNulls() {
      val src = DataB(null, null, ValueText("value"))
      val tgt = DataB(1, "test", null)
      src.copyTo(tgt)
      assertEquals(1, tgt.a)
      assertEquals("test", tgt.b)
      assertEquals("value", tgt.c?.text)
   }
}
