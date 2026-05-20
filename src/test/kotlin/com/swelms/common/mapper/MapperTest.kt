package com.swelms.common.mapper

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class MapperTest {
   data class Class1(val id: Int, val name: String, val other: String)
   data class Class2(val id: Int, var name: String, val other: Boolean = false)
   @Test
   fun compare(){
      val comp = compareProperties<Class1, Class2>()
      assertEquals(2, comp.size)
      assertEquals(comp[0].second.name, comp[0].first.name)
   }

   @Test
   fun copy(){
      val a = Class1(1, "HOLA", "B")
      val b = Class2(2, "CHAU", true)

      assertEquals(2, b.id)
      assertEquals("CHAU", b.name)
      copyProperties(a, b)
      assertEquals(2, b.id)
      assertEquals("HOLA", b.name)

   }

   @Test
   fun copyTo(){
      val a = Class1(1, "HOLA", "B")
      val b = Class2(2, "CHAU", true)

      assertEquals(2, b.id)
      assertEquals("CHAU", b.name)
      a.copyTo(b)
      assertEquals(2, b.id)
      assertEquals("HOLA", b.name)

   }

   @Test
   fun create(){
      val a = Class1(1, "HOLA", "B")
      val b = createFrom<Class1, Class2>(a)
      assertTrue {  b is Class2 }
      assertEquals(1, b.id)
      assertEquals("HOLA", b.name)
      assertEquals(false, b.other)
   }

   @Test
   fun createFails(){
      data class Class3(val id: Int, val name: String)
      val c = Class3(1, "HOLA")

      assertFailsWith<IllegalArgumentException> { createFrom<Class3, Class1>(c) }
   }


   @Test
   fun createFailsNoPrimaryConstructor() {
      class Class4 { private constructor()}

      val source = Class1(1, "HOLA", "B")

      assertFailsWith<InstantiationException> {
         createFrom<Class1, Class4>(source)
      }

   }
}