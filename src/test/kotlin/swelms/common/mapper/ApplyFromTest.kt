package swelms.common.mapper

import kotlinx.datetime.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplyFromTest {
   @Test
   fun compareProperties(){
      data class Class1(val id: Int, val name: String, val other: String)
      data class Class2(val id: Int, var name: String, val other: Boolean = false)

      val comp = compareProperties<Class1, Class2>()
      assertEquals(2, comp.size)
      assertEquals(comp[0].second.name, comp[0].first.name)
   }

   @Test
   fun copyFromOther(){
      data class Class1(val id: Int, val name: String, val other: String)
      data class Class2(val id: Int, var name: String, val other: Boolean = false)

      val a = Class1(1, "JUAN", "B")
      val b = Class2(2, "PEPE", true)

      assertEquals(2, b.id)
      assertEquals("PEPE", b.name)
      b.copyFrom(a)
      assertEquals(2, b.id)
      assertEquals("JUAN", b.name)

   }

   @Test
   fun copyFromWithBlock(){
      data class Class1(var id: Int, var name: String)
      data class Class2(val id: Int, var nombre: String)

      val a = Class1(1, "JUAN")
      val b = Class2(2, "PEPE")

      a.copyFrom(b){ name = it.nombre }
      assertEquals(2, a.id)
      assertEquals("PEPE", a.name)

   }


   @Test
   fun copyFrom() {
      data class Customer(var name: String = "", var birthday: LocalDate? = null)
      data class Person(val nombre: String, val nacimiento: LocalDate)

      val persona = Person("Ana", LocalDate.parse("2000-01-01"))

      val customer = Customer().applyFrom(persona) {
         name = it.nombre
         birthday = it.nacimiento
      }

      assertEquals("Ana", customer.name)
      assertEquals(LocalDate.parse("2000-01-01"), customer.birthday)
   }


}

