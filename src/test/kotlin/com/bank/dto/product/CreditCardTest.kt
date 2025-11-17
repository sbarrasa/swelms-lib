package com.bank.dto.product

import com.bank.product.structure.Branch
import kotlinx.datetime.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class CreditCardTest {
   @Test
   fun create() {
      val product = CreditCard(
         branch = Branch.VISA,
         number = "1111222233334444",
         expirationDate = LocalDate(dayOfMonth = 1, monthNumber = 1, year = 2028),
         creditLimit = 123456789.0,
         tier = "Gold"
      )

      assertEquals(CreditCard.id, product.descriptor.id)

   }
}