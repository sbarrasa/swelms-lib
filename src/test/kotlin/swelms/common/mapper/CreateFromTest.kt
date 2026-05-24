package swelms.common.mapper

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class CreateFromTest {


   @Test
   fun createFromMap() {
      data class Person(val name: String, val age: Int)

      val map = mapOf("name" to "Alice", "age" to 25)
      val person = createFromMap<Person>(map)

      assertNotNull(person)
      assertEquals("Alice", person.name)
      assertEquals(25, person.age)
   }

   @Test
   fun createFrom(){
      data class Person(val name: String, val age: Int)
      data class Persona(val name: String, val id: Int = 1)

      val a = Person("Juan", 45)

      val b = createFrom<Persona>(a)
      assertEquals(1, b.id)
      assertEquals("Juan", b.name)
   }



   @Test
   fun createFailsNoPrimaryConstructor() {
      class Class1(val name: String)
      class Class2 { private constructor()}

      val source = Class1("abc")
      assertFailsWith<InstantiationException> {
         createFrom<Class2>(source)
      }
   }
}