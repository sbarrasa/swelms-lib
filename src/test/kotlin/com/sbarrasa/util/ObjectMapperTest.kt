package com.sbarrasa.util

import kotlinx.datetime.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ObjectMapperTest {
   interface PersonInterface {
      var name: String?
      var age: Int?
   }

   data class Person(
      override var name: String? = null,
      override var age: Int? = null
   ) : PersonInterface

   data class Persona(var edad: Int? = null, var nombre: String? = null)

   data class Customer(val id: Int, override var name: String?, override var age: Int?) : PersonInterface

   data class InvariantPerson(val name: String, val age: Int)

   data class PersonWithBirthDate(val name: String?, val birthDay: LocalDate)


   @Test
   fun mapWithallData() {
      val mapper = ObjectMapper {
         bind(Person::name, Persona::nombre)
         bind(Person::age, Persona::edad)
      }

      val source = Person("Juan", 20)
      val target = Persona(nombre = "Pepe", edad = 42)

      assertEquals("Pepe", target.nombre)
      mapper.map(source, target)
      assertEquals("Juan", target.nombre)
   }

   @Test
   fun mapWithNullData() {
      val mapper = ObjectMapper {
         bind(Person::name, Persona::nombre)
         bind(Person::age, Persona::edad)
      }

      val source = Person(age = 20)
      val target = Persona(nombre = "Pepe", edad = 42)

      assertEquals("Pepe", target.nombre)
      mapper.map(source, target)
      assertEquals("Pepe", target.nombre)
   }

   @Test
   fun mapNotIgnoreNulls() {
      val mapper = ObjectMapper {
         bindAll(Person::class, Person::class)
         ignoreSourceNulls = false
      }

      val source = Person(age = 20)
      val target = Person(name = "Pepe", age = 42)

      assertEquals("Pepe", target.name)
      mapper.map(source, target)
      assertNull(target.name)
   }

   @Test
   fun mapSameClass() {
      val mapper = ObjectMapper {
         bindAll(Customer::class, Person::class)
      }

      val customer = Customer(1, "Juan", 38)
      val person = Person()

      mapper.map(customer, person)

      assertEquals("Juan", person.name)

   }

   @Test
   fun mapOneAnecestorClass() {
      val mapper = ObjectMapper.bindAll(PersonInterface::class)

      val customer = Customer(1, "Juan", 38)
      val person = Person()

      mapper.map(customer, person)

      assertEquals("Juan", person.name)

   }

   @Test
   fun mapInvariant() {
      val mapper = ObjectMapper { bindAll(InvariantPerson::class, Person::class) }

      val person1 = InvariantPerson("Juan", 20)
      val person2 = Person()

      assertNull(person2.name)

      mapper.map(person1, person2)
      assertEquals("Juan", person2.name)
   }

   @Test
   fun createWithMap() {
      val mapper = ObjectMapper { bindAll(InvariantPerson::class, Person::class) }

      val person1 = InvariantPerson("Juan", 20)
      val person2 = mapper.map(person1, Person())
      assertEquals("Juan", person2.name)

   }

   @Test
   fun mapWithLambdagetter() {
      val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

      val mapper = ObjectMapper<PersonWithBirthDate, Person> {
         bind(PersonWithBirthDate::name, Person::name)
         bind(
            { it.birthDay.yearsUntil(today) },
            Person::age
         )
      }

      val person1 = PersonWithBirthDate("María", today.minus(30, DateTimeUnit.YEAR))
      val person2 = Person()

      mapper.map(person1, person2)

      assertEquals("María", person2.name)
      assertEquals(30, person2.age)
   }
}
