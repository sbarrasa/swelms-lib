package com.bank.model.customer

import com.sbarrasa.domain.person.Name
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerTest {
   val customer1 = Customer(
      id = 1,
      legalName = Name("Barrasa, Sebastian Gabriel"),
      birthDay = LocalDate(1974, Month.JUNE, 7),
      gender = Gender.M
   )

   @Test
   fun birthDayTest() {
      assertEquals(Month.JUNE, customer1.birthDay!!.month)
   }

}