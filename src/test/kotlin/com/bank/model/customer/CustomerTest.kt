package com.bank.model.customer

import com.swelms.domain.cuit.Cuit
import com.swelms.domain.person.FullName
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerTest {

   val customer1 = Customer(
      fullName = FullName("Barrasa, Sebastián Gabriel"),
      birthDay = LocalDate(1974, Month.JUNE, 7),
      gender = Gender.M,
      cuit = Cuit("20240614708")
   )

   @Test
   fun jsonDeserializationTest() {
      val json = """
        {
            "fullName": "Barrasa, Sebastián Gabriel",
            "birthDay": "1974-06-07",
            "gender": "M",
            "cuit": "20240614708"
        }
      """
      val customer = Json.decodeFromString<Customer>(json)
      assertEquals(customer1, customer)
   }
   @Test
   fun birthDayTest() {
      assertEquals(Month.JUNE, customer1.birthDay!!.month)
   }

}