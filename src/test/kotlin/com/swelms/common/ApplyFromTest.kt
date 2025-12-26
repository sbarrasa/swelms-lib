package com.swelms.common


import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.datetime.LocalDate


class ApplyFromTest {
   data class Customer(var name: String = "", var birthday: LocalDate? = null)
   data class Person(val nombre: String, val nacimiento: LocalDate)

   @Test
   fun testApplyFrom() {
      val persona = Person("Ana", LocalDate.parse("2000-01-01"))

      val customer = Customer().applyFrom(persona) {
         name = it.nombre
         birthday = it.nacimiento
      }

      assertEquals("Ana", customer.name)
      assertEquals(LocalDate.parse("2000-01-01"), customer.birthday)
   }

   @Test
   fun testMultipleApplyFrom() {
      val c1 = Customer()
      val c2 = Customer()
      val persona = Person("Luis", LocalDate.parse("1990-05-10"))

      c1.applyFrom(persona) { name = it.nombre; birthday = it.nacimiento }
      c2.applyFrom(persona) { name = it.nombre; birthday = it.nacimiento }

      assertEquals("Luis", c1.name)
      assertEquals(LocalDate.parse("1990-05-10"), c1.birthday)
      assertEquals("Luis", c2.name)
      assertEquals(LocalDate.parse("1990-05-10"), c2.birthday)
   }
}
