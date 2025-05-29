package com.bank.service

import com.bank.model.customer.Customer
import com.bank.model.customer.Gender
import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlin.test.*

class CustomerMapperTest{

    @Test
    fun mapAll(){
        val customer1 = Customer(
            name = "Sebastian",
            lastName = "Barrasa",
            gender = Gender.M,
            birthDay = LocalDate(1974, Month.JUNE, 7)
        )

        val customer2 = Customer()

        CustomerMapper.map(customer1, customer2)

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

        CustomerMapper.map(updateCustomer, currentCustomer)
        assertEquals("Sebastian", currentCustomer.name)
        assertEquals(Gender.M, currentCustomer.gender)

    }
}