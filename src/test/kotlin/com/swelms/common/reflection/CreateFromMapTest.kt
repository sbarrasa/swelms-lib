package com.swelms.common.reflection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class CreateFromMapTest {
   data class Person(val name: String, val age: Int)


   @Test
   fun createFromMapReified() {
      val map = mapOf("name" to "Alice", "age" to 25)
      val person = createFromMap<Person>(map)

      assertNotNull(person)
      assertEquals("Alice", person.name)
      assertEquals(25, person.age)
   }

   @Test
   fun createFromMapClass() {
      val map = mapOf("name" to "Alice", "age" to 25)
      val person = createFromMap(Person::class, map)

      assertNotNull(person)
      assertEquals("Alice", person.name)
      assertEquals(25, person.age)
   }



}