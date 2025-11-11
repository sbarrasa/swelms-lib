package com.sbarrasa.util.objectcopy

import kotlin.test.Test
import kotlin.test.assertEquals

data class Source(val a: Int?, val b: String?, val c: Double?)
data class Target(var a: Int? = null, var b: String? = null, var c: Double? = null)

class ObjectMapperTest {

   @Test
   fun testMap() {
      val source = Source(10, "hello", 3.14)
      val target = Target()
      copy(source, target)
      assertEquals(10, target.a)
      assertEquals("hello", target.b)
      assertEquals(3.14, target.c)
   }

   @Test
   fun testMapTo() {
      val source = Source(42, "world", null)
      val target = Target(a = 1, b = "old", c = 2.0)
      source.copyTo(target)
      assertEquals(42, target.a)
      assertEquals("world", target.b)
      assertEquals(2.0, target.c)
   }

   @Test
   fun testMapIgnoreNullsTrue() {
      val source = Source(null, "new", null)
      val target = Target(a = 5, b = "old", c = 7.0)
      copy(source, target)
      assertEquals(5, target.a)
      assertEquals("new", target.b)
      assertEquals(7.0, target.c)
   }

   @Test
   fun testMapIgnoreNullsFalse() {
      val source = Source(null, "new", null)
      val target = Target(a = 5, b = "old", c = 7.0)
      copy(source, target, ignoreNulls = false)
      assertEquals(null, target.a)
      assertEquals("new", target.b)
      assertEquals(null, target.c)
   }
}
