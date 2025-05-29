package com.bank.model.customer

import kotlinx.datetime.LocalDate
import java.time.Month
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerTest{
    @Test
    fun create() {
        val customer1 = Customer(
            id = 1,
            name="Sebastian",
            lastName = "Barrasa",
            birthDay = LocalDate(1974, Month.JUNE, 7 ),
            gender = Gender.M
        )

        assertEquals(Month.JUNE, customer1.birthDay!!.month)

    }
}