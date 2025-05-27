package com.sbarrasa.bank.entities.customer

import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerMapperTest{
    val mapper = CustomerMapper()

    @Test
    fun mapAll(){
       val customer1 = Customer(
           name = "Sebastian",
           lastName = "Barrasa",
           gender = Gender.M,
           birthDay = LocalDate(1974, Month.JUNE, 7)
       )

       val customer2 = Customer()

       mapper.map(customer1, customer2)

       assertEquals("Sebastian", customer2.name)

    }

    @Test
    fun mapWithNulls(){

        val currentCustomer = Customer(
            name = "Sebastian",
            lastName = "Barrasa",
            gender = Gender.F,
            birthDay = LocalDate(1974, Month.JUNE, 7)
        )

        val updateCustomer = Customer(gender = Gender.M)

        assertEquals("Sebastian", currentCustomer.name)
        assertEquals(Gender.F, currentCustomer.gender)

        mapper.map(updateCustomer, currentCustomer)
        assertEquals("Sebastian", currentCustomer.name)
        assertEquals(Gender.M, currentCustomer.gender)

    }
}